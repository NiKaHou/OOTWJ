package decorator_pattern;

public class Border extends Decorator{
	private String style = "-fx-border-width:";
	private String value;
	public Border(DecoratorComponent component, String value) {
		super(component);
		this.value = value;
	}

	public String getStyle() {
		return this.style + this.value + "; " + this.component.getStyle();
	}
}
