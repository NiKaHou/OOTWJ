import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import wordCount_Visitor_Iterator.AnotherVisitor;
import wordCount_Visitor_Iterator.AnotherWord;
import wordCount_Visitor_Iterator.EngVisitor;
import wordCount_Visitor_Iterator.EnglishWord;
import wordCount_Visitor_Iterator.Visitor;

public class MainPage{
	@FXML
	private AnchorPane mainPane;
	@FXML
	private HTMLEditor htmlEditor;
	@FXML
	private Label labelShow = new Label();
	@FXML
	public void initialize() {
		initEditorPane();
		initEditorToolBar();
	}
	private void initEditorPane() {
		WebView webView = (WebView) htmlEditor.lookup(".web-view");
		webView.setPrefSize(0, 680);
		htmlEditor.setOnKeyReleased(EventHandler -> {
			getCount(delHtmlTags(htmlEditor.getHtmlText()));
		});
	}
	private void initEditorToolBar() {
		ToolBar toolBar = (ToolBar)htmlEditor.lookup(".top-toolbar");
		ImageView graphic = new ImageView(
				new Image("img/add-img.png",16,16,true,true)
				);
		Button insertImgBtn = new Button("", graphic);
		toolBar.getItems().add(insertImgBtn);
		insertImgBtn.setOnAction(event -> {
		try {
			onImportImgButtonAction();
		} catch (IOException e) {
			e.printStackTrace();
		}
		});
	}
	
	private void onImportImgButtonAction() throws IOException {
		FileChooser fileChooser = new FileChooser();
		List<String> extensionsList = new ArrayList<String>();
		extensionsList.add("png");
		extensionsList.add("jpg");
		fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("only (png/jpg)", extensionsList));
		File selectedFile = fileChooser.showOpenDialog(htmlEditor.getScene().getWindow());
		if (selectedFile != null) {
			String typeString = Files.probeContentType(selectedFile.toPath());
			@SuppressWarnings("resource")
			FileInputStream fileInputStream = new FileInputStream(selectedFile);
			byte[] bytes = new byte[(int)selectedFile.length()];
			fileInputStream.read(bytes);
			String base64 = new String(Base64.getEncoder().encodeToString(bytes));
			String htmlImg = String.format("<img src=\'%s\' />", "data:"+typeString+";base64,"+base64);

			htmlImg = htmlImg.replace("\\", "\\\\")
					.replace("\"", "\\\"")
					.replace("\r", "\\r")
					.replace("\n", "\\n");
			
			String script = String.format(
	                "(function(html) {"
	                + "  var sel, range;"
	                + "  if (window.getSelection) {"
	                + "    sel = window.getSelection();"
	                + "    if (sel.getRangeAt && sel.rangeCount) {"
	                + "      range = sel.getRangeAt(0);"
	                + "      range.deleteContents();"
	                + "      var el = document.createElement(\"div\");"
	                + "      el.innerHTML = html;"
	                + "      var frag = document.createDocumentFragment(),"
	                + "        node, lastNode;"
	                + "      while ((node = el.firstChild)) {"
	                + "        lastNode = frag.appendChild(node);"
	                + "      }"
	                + "      range.insertNode(frag);"
	                + "      if (lastNode) {"
	                + "        range = range.cloneRange();"
	                + "        range.setStartAfter(lastNode);"
	                + "        range.collapse(true);"
	                + "        sel.removeAllRanges();"
	                + "        sel.addRange(range);"
	                + "      }"
	                + "    }"
	                + "  }"
	                + "  else if (document.selection && "
	                + "           document.selection.type != \"Control\") {"
	                + "    document.selection.createRange().pasteHTML(html);"
	                + "  }"
	                + "})(\"%s\");", htmlImg);
			
			WebView webView = (WebView) htmlEditor.lookup(".web-view");
			webView.getEngine().executeScript(script);
		}
	}

	private void getCount(String word) {    	
    	String[] words = word.split("\\s+");	//���ִ��Կհ׷ָ�(e.g.Ӣ�ľ���)
    	
    	EnglishWord eWords = new EnglishWord();	//element
    	AnotherWord aWords = new AnotherWord();
    	
    	Visitor eVisitor = new EngVisitor();	//visitor
    	AnotherVisitor cVisitor = new AnotherVisitor();
    	
    	//�Д�Ҏ�t��Ӣ���֞�Ӣ���ִ������ļ����c��̖�ȵȞ������ִ�
    	//Ӣ�����B��һ��ҕ��һ���֣��oՓ���L
    	//���ļ����c��̖һ���ּ���һ����
    	
    	for(int i = 0 ; i < words.length ; i++) {	//��words��������е��ִ�
    		
    		if(isEngOrNum(words[i])) {	//��������Ӣ��(Ӣ����)�t����Ӣ���ֵ�element��
    			eWords.add(words[i]);
    		}else {
    			String engString = "";
    			while(words[i].length() > 0) {
    				//������Ӣ�Ļ��s�t���_̎��
    				if(isEngOrNum(words[i].substring(0, 1))) {
    					
    					engString = engString + words[i].substring(0, 1);
    				}else if(("\\n").equals(words[i].substring(0, 1)) || ("\\r").equals(words[i].substring(0, 1))){
    					aWords.add(words[i].substring(0, 1));
    					if(engString!="") {
    						eWords.add(engString);
    						engString = "";
    					}
    				}else {
    					aWords.add(words[i].substring(0, 1));
    					if(engString!="") {
    						eWords.add(engString);
    						engString = "";
    					}
    				}
    				words[i] = words[i].substring(1, words[i].length());
    			}
    			if(engString!="") {
					eWords.add(engString);
				}
    		}
    	}
    	
    	eVisitor.visit(eWords);	//���L
    	cVisitor.visit(aWords);
    	//顯示的label
    	labelShow.setText("英文字數"+(eVisitor.getWordCount()) +"個"+"特殊符號及中文"+cVisitor.getWordCount()+"個");    
	}
	
    private boolean isEngOrNum(String aWord) {	//�Д��ִ��Ƿ��Ӣ����

    	int wordLen = 0;
    	for(int j = 0 ; j < aWord.length() ; j++) {
			char ch = aWord.charAt(j);
			if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				wordLen++;
			}
		}
    	
    	if(wordLen == aWord.length()) {
    		return true;
    	}
    	return false;
    }

    private String delHtmlTags(String htmlStr) {	
    	
    	//�����t���_ʽ�Ƴ�htmlTAG
    	//h1~h6��p�����ГQ�е�Ч�������ԵÌ��������e̎��
    	//��tֱ���Ƴ����c�¶����B��һ�����Ԍ������D�ɿո�
    	String regEx_1 = "<h1.*?>";
    	Pattern p_h1 = Pattern.compile(regEx_1, Pattern.CASE_INSENSITIVE);
    	Matcher m_h1 = p_h1.matcher(htmlStr);
    	htmlStr = m_h1.replaceAll(" ");
    	
    	String regEx_2 = "<h2.*?>";
    	Pattern p_h2 = Pattern.compile(regEx_2, Pattern.CASE_INSENSITIVE);
    	Matcher m_h2 = p_h2.matcher(htmlStr);
    	htmlStr = m_h2.replaceAll(" ");
    	
    	String regEx_3 = "<h3.*?>";
    	Pattern p_h3 = Pattern.compile(regEx_3, Pattern.CASE_INSENSITIVE);
    	Matcher m_h3 = p_h3.matcher(htmlStr);
    	htmlStr = m_h3.replaceAll(" ");
    	
    	String regEx_4 = "<h4.*?>";
    	Pattern p_h4 = Pattern.compile(regEx_4, Pattern.CASE_INSENSITIVE);
    	Matcher m_h4 = p_h4.matcher(htmlStr);
    	htmlStr = m_h4.replaceAll(" ");
    	
    	String regEx_5 = "<h5.*?>";
    	Pattern p_h5 = Pattern.compile(regEx_5, Pattern.CASE_INSENSITIVE);
    	Matcher m_h5 = p_h5.matcher(htmlStr);
    	htmlStr = m_h5.replaceAll(" ");
    	
    	String regEx_6 = "<h6.*?>";
    	Pattern p_h6 = Pattern.compile(regEx_6, Pattern.CASE_INSENSITIVE);
    	Matcher m_h6 = p_h6.matcher(htmlStr);
    	htmlStr = m_h6.replaceAll(" ");
    	
    	String regEx_p = "<p.*?>";
    	Pattern p_p = Pattern.compile(regEx_p, Pattern.CASE_INSENSITIVE);
    	Matcher m_p = p_p.matcher(htmlStr);
    	htmlStr = m_p.replaceAll(" ");
    	
    	//�˞鰴��enter�I��space�I�����F���ַ��������D�ɿո�
    	String regEx_space = "&nbsp;";
    	Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
    	Matcher m_space = p_space.matcher(htmlStr);
    	htmlStr = m_space.replaceAll(" ");
    	
    	//��ʣ�N����TAG�Ƴ�
    	String regEx_html = "<[^>]*>";
    	Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); 
       
        return htmlStr.trim();	//��߀������
    }
    
    

}
