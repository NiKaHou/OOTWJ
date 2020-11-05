package factory_pattern;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.stage.Stage;
import strategy_pattern.WindowColor;
import strategy_pattern.WindowDark;
import strategy_pattern.WindowNormal;

abstract public class WindowFactory<Main> {
	protected Main mainClass;
	protected Map<String, WindowColor> strategyMapping = new HashMap<String, WindowColor>();
	public WindowFactory(Main mainClass) {
		this.mainClass = mainClass;
		this.strategyMapping.put("small", new WindowDark());
		this.strategyMapping.put("large", new WindowNormal());
	}
	abstract public Stage createMainPage () throws IOException;
}
