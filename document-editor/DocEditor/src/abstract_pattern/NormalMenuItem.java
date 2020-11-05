package abstract_pattern;

import javafx.scene.control.MenuItem;

public class NormalMenuItem extends MenuItem{
	public NormalMenuItem() {
		this.setMnemonicParsing(false);
		this.setStyle("-fx-font-size: 12px;");
	}
}
