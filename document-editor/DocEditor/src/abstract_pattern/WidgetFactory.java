package abstract_pattern;

import bridge_pattern.FileItemProcess;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

abstract public class WidgetFactory {
	protected Stage stage;
	protected AnchorPane anchorPane;

	public WidgetFactory(Stage stage) {
		this.stage = stage;
		this.anchorPane = (AnchorPane) stage.getScene().lookup("#mainPane");
	}
	abstract public void createWidgets();
	abstract public void setOperateSystem(FileItemProcess NowFileitemProcess);
}
