package composite_pattern;

public class MenuBarLeaf extends MenuBarComponent{
	private String b_name;
	private String type;
	public MenuBarLeaf(String b_name, String type){
		this.b_name = b_name;
		this.type = type;
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
