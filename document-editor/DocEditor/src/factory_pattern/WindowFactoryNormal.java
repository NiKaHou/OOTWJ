package factory_pattern;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowFactoryNormal<Main> extends WindowFactory<Main>{
	public WindowFactoryNormal(Main mainClass) {
		super(mainClass);
	}

	@Override
	public Stage createMainPage() throws IOException {
		Stage primaryStage = new Stage();
		Parent mainPage = FXMLLoader.load(this.mainClass.getClass().getResource("MainPage.fxml"));
		Scene mainScene = new Scene(mainPage);
		primaryStage.setTitle("Editor");
		primaryStage.setScene(mainScene);
		primaryStage.show();
		setWindowColor(primaryStage);
		return primaryStage;
	}
	private void setWindowColor(Stage stage) {
		this.strategyMapping.get("large").setWindowSize(stage);
	}
}
