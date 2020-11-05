package abstract_pattern;

import javafx.scene.control.MenuItem;

public class DarkMenuItem extends MenuItem{
	public DarkMenuItem() {
		this.setMnemonicParsing(false);
		this.setStyle("-fx-font-size: 12px;");
		
		this.setStyle("-fx-background-color: darkgray;"
				+ "-fx-text-fill: snow;"
				+ "-fx-focus-color: blue");
//		this.setStyle("-fx-text-fill: greenyellow;");
	}
}
