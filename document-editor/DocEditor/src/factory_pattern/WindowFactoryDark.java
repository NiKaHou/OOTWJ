package factory_pattern;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowFactoryDark<Main> extends WindowFactory<Main>{
	public WindowFactoryDark(Main mainClass) {
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
		setWindowSize(primaryStage);
		return primaryStage;
	}
	private void setWindowSize(Stage stage) {
		this.strategyMapping.get("small").setWindowSize(stage);
	}
}
