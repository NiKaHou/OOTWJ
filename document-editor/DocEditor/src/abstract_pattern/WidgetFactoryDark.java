package abstract_pattern;

import java.io.IOException;

import bridge_pattern.FileItemProcess;
import composite_pattern.MenuBarComponent;
import composite_pattern.MenuBarComposite;
import composite_pattern.MenuBarLeaf;
import decorator_pattern.Border;
import decorator_pattern.Color;
import decorator_pattern.DecoratorComponent;
import decorator_pattern.Widget;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class WidgetFactoryDark extends WidgetFactory{
	FileItemProcess fileitemprocess;
	private MenuBar menuBar;

	public WidgetFactoryDark(Stage stage) {
		super(stage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createWidgets() {
		MenuBarComponent component = createMenuBarComponent();
		menuBar = createMenuBar(component);
		anchorPane.getChildren().add(menuBar);
	}
	
	private MenuBarComponent createMenuBarComponent() {
		MenuBarComponent root = new MenuBarComposite("root", "MenuBar");
		
		MenuBarComponent file = new MenuBarComposite("file", "Menu");
		MenuBarComponent newMenuBar = new MenuBarLeaf("new", "MenuItem");
		MenuBarComponent saveMenuBar = new MenuBarLeaf("save", "MenuItem");
		MenuBarComponent loadMenuBar = new MenuBarLeaf("load", "MenuItem");
		file.add(newMenuBar);
		file.add(saveMenuBar);
		file.add(loadMenuBar);
		
		MenuBarComponent menuStyle = new MenuBarComposite("style", "Menu");
		MenuBarComponent thickBlue = new MenuBarLeaf("thick blue", "MenuItem");
		MenuBarComponent thinPink = new MenuBarLeaf("thin pink", "MenuItem");
		MenuBarComponent none = new MenuBarLeaf("none", "MenuItem");
		menuStyle.add(thickBlue);
		menuStyle.add(thinPink);
		menuStyle.add(none);

//		MenuBarComponent urdo = new MenuBarComposite("urdo" , "Menu");
//		MenuBarComponent undo = new MenuBarLeaf("undo" , "MenuItem");
//		MenuBarComponent redo = new MenuBarLeaf("redo" , "MenuItem");
//		urdo.add(undo);
//		urdo.add(redo);
		
		
		root.add(file);
		root.add(menuStyle);
//		root.add(urdo);
		
		return root;
	}

	private MenuBar createMenuBar(MenuBarComponent component) {
		MenuBarComponent tmpMenuComponent;
		MenuBarComponent tmpMenuItemComponent;
		MenuBar menuBar = new DarkMenuBar();
		while (component.hasChild()) {
			tmpMenuComponent = component.getChild();
			Menu menu = new DarkMenu();
			menu.setText(tmpMenuComponent.getTitle());
			menuBar.getMenus().add(menu);
			while (tmpMenuComponent.hasChild()) {
				tmpMenuItemComponent = tmpMenuComponent.getChild();
				MenuItem menuItem = new DarkMenuItem();
				menuItem.setText(tmpMenuItemComponent.getTitle());
				setAction(menuItem, tmpMenuItemComponent.getTitle());
				menu.getItems().add(menuItem);
			}
		}
		return menuBar;
	}
	private void setAction(MenuItem menuItem, String functionName) {
		if(functionName.equals("new")) {
			menuItem.setOnAction(e -> {
				HTMLEditor htmlEditor = (HTMLEditor) stage.getScene().lookup("#htmlEditor");
				htmlEditor.setHtmlText("");
			});
		}else if (functionName.equals("save")) {
			menuItem.setOnAction(e -> {
				fileitemprocess.SaveProcess(stage);
			});
		}else if (functionName.equals("load")) {
			menuItem.setOnAction(e -> {
				try {
					fileitemprocess.OpenProcess(stage);
				} catch (IOException e1) {
					
				}
			});
		}else if (functionName.equals("thick blue")) {
			menuItem.setOnAction(e -> {
				DecoratorComponent component = new Widget();
				component = new Color(component, "blue");
				component = new Border(component, "6px");
				menuBar.setStyle(component.getStyle());
			});
		}else if (functionName.equals("thin pink")) {
			menuItem.setOnAction(e -> {
				DecoratorComponent component = new Widget();
				component = new Color(component, "pink");
				component = new Border(component, "3px");
				menuBar.setStyle(component.getStyle());
			});
		}else if (functionName.equals("none")) {
			menuItem.setOnAction(e -> {
				DecoratorComponent component = new Widget();
				menuBar.setStyle(component.getStyle());
			});
		}
	}

	@Override
	public void setOperateSystem(FileItemProcess NowFileitemProcess) {
		// TODO Auto-generated method stub
		fileitemprocess = NowFileitemProcess;
	}

}
