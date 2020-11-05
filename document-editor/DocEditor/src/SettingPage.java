import java.io.IOException;

import abstract_pattern.WidgetFactory;
import abstract_pattern.WidgetFactoryNormal;
import abstract_pattern.WidgetFactoryDark;
import bridge_pattern.FileItemProcess_Linux;
import bridge_pattern.FileItemProcess_Window;
import factory_pattern.WindowFactory;
import factory_pattern.WindowFactoryDark;
import factory_pattern.WindowFactoryNormal;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class SettingPage {
	@FXML
	private RadioButton radio_small;
	@FXML
	private RadioButton radio_full;
	@FXML
	private Button comfirmSizeButton;
	@FXML
	public void initialize() {
		initSettingPage();
	}	
	private void initSettingPage() {
		comfirmSizeButton.setOnAction(EventHandler -> {
			try {
				if (radio_full.isSelected()) {
					createMainPageSmall();
				}else{
					createMainPageLarge();
				}
				Main.getSettingStage().hide();
			} catch (IOException e) {

				e.printStackTrace();
			}
		});
		
		radio_small.setOnAction(EventHandler -> {
			radio_full.setSelected(false);
		});
		radio_full.setOnAction(EventHandler -> {
			radio_small.setSelected(false);
		});
	}
	private void createMainPageSmall() throws IOException {
		WindowFactory<Main> windowFactory = new WindowFactoryDark<Main>(Main.getInstance());
		Stage stage = windowFactory.createMainPage();
		WidgetFactory widgetFactory = new WidgetFactoryDark(stage);
		widgetFactory.createWidgets();
		//SET OPERATESYSTEM
				String systemVersions = System.getProperty("os.name");
				if(systemVersions.indexOf("Windows") >= 0){
					widgetFactory.setOperateSystem(new FileItemProcess_Window());
					System.out.println("this is windows !");}
				else if(systemVersions.indexOf("Linux") >= 0){
					widgetFactory.setOperateSystem(new FileItemProcess_Linux());
					System.out.println("this is Linux !");}
				else{ 
					System.out.println("OPERATESYSTEM CAN NOT SUPPORT");}
	}
	private void createMainPageLarge() throws IOException {
		WindowFactory<Main> windowFactory = new WindowFactoryNormal<Main>(Main.getInstance());
		Stage stage = windowFactory.createMainPage();
		WidgetFactory widgetFactory = new WidgetFactoryNormal(stage);
		widgetFactory.createWidgets();
		//SET OPERATESYSTEM
				String systemVersions = System.getProperty("os.name");
				if(systemVersions.indexOf("Windows") >= 0){
					widgetFactory.setOperateSystem(new FileItemProcess_Window());
					System.out.println("this is windows !");}
				else if(systemVersions.indexOf("Linux") >= 0){
					widgetFactory.setOperateSystem(new FileItemProcess_Linux());
					System.out.println("this is Linux !");}
				else{ 
					System.out.println("OPERATESYSTEM CAN NOT SUPPORT");}
	}

}
