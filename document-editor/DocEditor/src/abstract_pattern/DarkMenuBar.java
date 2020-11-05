package abstract_pattern;

import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;

public class DarkMenuBar extends MenuBar{
	DarkMenuBar(){
		AnchorPane.setLeftAnchor(this, 0.0);
		AnchorPane.setTopAnchor(this, 0.0);
		AnchorPane.setRightAnchor(this, 0.0);
		this.setStyle("-fx-background-color: darkgray;"
				+ "-fx-text-fill: snow;");
		this.setPrefHeight(32);
	}
}
