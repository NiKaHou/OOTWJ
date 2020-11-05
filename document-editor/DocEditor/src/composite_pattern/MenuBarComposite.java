package composite_pattern;

import java.util.LinkedList;

public class MenuBarComposite extends MenuBarComponent{
	LinkedList<MenuBarComponent> mb_linkedList = new LinkedList<MenuBarComponent>();
	private String b_name;
	private String type;
	public MenuBarComposite(String b_name, String type) {
		this.b_name = b_name;
		this.type = type;
	}
	@Override
	public void add(MenuBarComponent m_component) {
		mb_linkedList.add(m_component);
	}
	@Override
	public void remove(MenuBarComponent m_component) {
		mb_linkedList.remove(m_component);
	}
	@Override
	public boolean hasChild() {
		if(mb_linkedList.size() > 0) {
			return true;
		}
		return false;
	}
	@Override
	public MenuBarComponent getChild() {
		return mb_linkedList.pop();
	}
	@Override
	public String getTitle() {

		return this.b_name;
	}
	@Override
	public String getType() {

		return this.type;
	}
}
