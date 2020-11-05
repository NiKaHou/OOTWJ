package abstract_pattern;

import javafx.scene.control.Menu;

public class DarkMenu extends Menu{
	public DarkMenu() {
		this.setMnemonicParsing(false);
		this.setStyle("-fx-font-size: 18px;"
				+ "-fx-background-color: darkgray;"
				+ "-fx-text-fill: snow;"
				+ "-fx-focus-color: blue");
	}
}
