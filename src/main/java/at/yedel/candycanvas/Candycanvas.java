package at.yedel.candycanvas;


import at.yedel.candycanvas.config.CandyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*? if fabric {*/
import net.fabricmc.api.ModInitializer;
    /*?} else if neoforge {*/
/*import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
    *//*?}*/



// Maud
/*? if neoforge */ //@Mod("candycanvas")
public class Candycanvas /*? if fabric {*/implements ModInitializer/*?}*/ {
	public static final Logger lavalog = LoggerFactory.getLogger("Candycanvas");

	private void initialize() {
		CandyConfig.getInstance().initialize();
		lavalog.info("Candycanvas!");
	}

	/*? if fabric {*/
	@Override
	public void onInitialize() {
		initialize();
	}
	/*?} elif neoforge {*/
	/*public Candycanvas(ModContainer container) {
		initialize();
	}
	*//*?}*/
}