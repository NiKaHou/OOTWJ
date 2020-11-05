package decorator_pattern;

abstract public class Decorator implements DecoratorComponent{
	protected DecoratorComponent component;
	public Decorator(DecoratorComponent component) {
		this.component = component;
	}
	
	public abstract String getStyle();
}
