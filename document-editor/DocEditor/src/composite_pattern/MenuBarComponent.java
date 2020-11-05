package composite_pattern;


public abstract class MenuBarComponent {
	public void add(MenuBarComponent component){
		throw new UnsupportedOperationException();
	}
	public void remove(MenuBarComponent component) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	public boolean hasChild() {
		throw new UnsupportedOperationException();
	}
	public MenuBarComponent getChild() {
		throw new UnsupportedOperationException();
	}
	abstract public String getTitle();
	abstract public String getType();
}
