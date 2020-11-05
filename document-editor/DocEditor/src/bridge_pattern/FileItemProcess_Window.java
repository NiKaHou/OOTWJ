
package bridge_pattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;




public class FileItemProcess_Window implements FileItemProcess{
	FileChooser fileChooser = new FileChooser();

	String pathname = "C:\\Users\\User\\Documents\\";
	
	public void SaveProcess(Stage stage) {
		fileChooser.setTitle("��n");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File fileS = fileChooser.showSaveDialog(stage);
        if(fileS != null) {
        	HTMLEditor htmlEditor = (HTMLEditor) stage.getScene().lookup("#htmlEditor");
        	saveTextToFile(htmlEditor.getHtmlText(), fileS);
        }
        
	}
	private void saveTextToFile(String text, File file) {
		try {
			PrintWriter writer;
			writer = new PrintWriter(file);
			writer.println(text);
			writer.close();
		} catch (IOException ex) {

		}
	}

	public void OpenProcess(Stage stage) throws IOException {		
		fileChooser.setInitialDirectory(new File(pathname));		
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File fileO = fileChooser.showOpenDialog(stage);
        if(fileO != null) {
        	HTMLEditor htmlEditor = (HTMLEditor) stage.getScene().lookup("#htmlEditor");
        	try {
				@SuppressWarnings("resource")
				BufferedReader bufferedReader = new BufferedReader(new FileReader(fileO));
				htmlEditor.setHtmlText(bufferedReader.readLine());
			} catch (FileNotFoundException e) {
			}
        }
	}
}
