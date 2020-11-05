
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
//	private WindowFactory<Main> windowFactory;
	static private Main main;
	static private Stage settingStage;
	
	public Main() {
		Main.main = this;
	}
	@Override
	public void start(Stage settingStage) throws IOException {
		Parent settingPage = FXMLLoader.load(getClass().getResource("SettingPage.fxml"));
		Scene settingScene = new Scene(settingPage);
		settingStage.setTitle("Setting");
		settingStage.setScene(settingScene);
		settingStage.show();
		Main.settingStage = settingStage;
	}
	
	static public Main getInstance() {
		return main;
	}
	
	
	
	
	
	static public Stage getSettingStage() {
		return Main.settingStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
