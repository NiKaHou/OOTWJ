package abstract_pattern;

import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;

public class NormalMenuBar extends MenuBar{
	NormalMenuBar(){
		AnchorPane.setLeftAnchor(this, 0.0);
		AnchorPane.setTopAnchor(this, 0.0);
		AnchorPane.setRightAnchor(this, 0.0);
		this.setPrefHeight(32);
	}
}
