package at.yedel.candycanvas;


import at.yedel.candycanvas.config.CandyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.api.ModInitializer;



// Maud
public class Candycanvas implements ModInitializer {
	public static final Logger lavalog = LoggerFactory.getLogger("Candycanvas");

	private void initialize() {
		CandyConfig.getInstance().initialize();
		lavalog.info("Candycanvas!");
	}

	@Override
	public void onInitialize() {
		initialize();
	}
}