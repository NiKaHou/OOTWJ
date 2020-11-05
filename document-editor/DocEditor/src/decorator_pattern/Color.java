package decorator_pattern;

public class Color extends Decorator{
	private String style = "-fx-border-color:";
	private String value;
	public Color(DecoratorComponent component, String value) {
		super(component);
		this.value = value;
	}

	public String getStyle() {
		return this.style + this.value + "; " + this.component.getStyle();
	}
}
