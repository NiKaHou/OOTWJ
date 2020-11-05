package strategy_pattern;

import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class WindowDark implements WindowColor{

	@Override
	public void setWindowSize(Stage stage) {
		stage.setWidth(600);
		stage.setHeight(900);
		stage.setResizable(false);
		HTMLEditor htmlEditor = (HTMLEditor)stage.getScene().lookup("#htmlEditor");
		AnchorPane.setTopAnchor(htmlEditor, 32.0);
	}
	
}
