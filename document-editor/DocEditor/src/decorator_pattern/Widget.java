package decorator_pattern;

public class Widget implements DecoratorComponent{
	private String style="";
	@Override
	public String getStyle() {
		return this.style;
	}
	
}
