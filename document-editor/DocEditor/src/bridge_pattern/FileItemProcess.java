package bridge_pattern;


import java.io.IOException;

import javafx.stage.Stage;

public interface FileItemProcess {
	public void SaveProcess(Stage stage);
	public void OpenProcess(Stage stage) throws IOException;
}
