package at.yedel.candycasts;



/*? if fabric {*/
import at.yedel.candycasts.config.CandyConfig;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
    /*?} else if neoforge {*/
/*import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
    *//*?}*/



// Maud
/*? if neoforge */ //@Mod("candycasts")
public class Candycasts /*? if fabric {*/implements ModInitializer/*?}*/ {
	public static final Logger lavalog = LoggerFactory.getLogger("Candycasts");

	private void initialize() {
		CandyConfig.getInstance().initialize();
		lavalog.info("Candycasts!");
	}

	/*? if fabric {*/
	@Override
	public void onInitialize() {
		initialize();
	}
	/*?} elif neoforge {*/
	/*public Candycasts(ModContainer container) {
		initialize();
	}
	*//*?}*/
}