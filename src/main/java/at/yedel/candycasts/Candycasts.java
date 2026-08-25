package at.yedel.candycasts;



/*? if fabric {*/
import net.fabricmc.api.ClientModInitializer;
/*?} else if neoforge {*/
/*import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
    *//*?}*/



// Maud
/*? if neoforge */ //@Mod("candycasts")
public class Candycasts /*? if fabric {*/implements ClientModInitializer/*?}*/ {
	/*? if fabric {*/
	@Override
	public void onInitializeClient() {
		
	}
	/*?} elif neoforge {*/
	/*public Candycasts(ModContainer container) {
		
	}
	*//*?}*/
}