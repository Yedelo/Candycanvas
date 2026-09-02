package at.yedel.candycanvas.config;



import com.supermartijn642.configlib.api.ConfigBuilders;
import com.supermartijn642.configlib.api.IConfigBuilder;

import java.util.function.Supplier;



public class CandyConfig {
    private static final CandyConfig INSTANCE = new CandyConfig();
    
    public static CandyConfig getInstance() {
        return INSTANCE;
    }
    
    private CandyConfig() {}

    public Supplier<Boolean> enabled;

    public Supplier<Boolean> randomizeLiquidCollisions;
    public Supplier<Boolean> randomizeStoneGeneration;
    public Supplier<Boolean> randomizeObsidianGeneration;
    public Supplier<Boolean> randomizeCobblestoneGeneration;
    public Supplier<Boolean> randomizeBasaltGeneration;

    public Supplier<Boolean> randomizeExplosions;

    public void initialize() {
        IConfigBuilder builder = ConfigBuilders.newJsonConfig("candycanvas", "Candycanvas", false);
        enabled = builder.comment("Global toggle for the mod.").define("enabled", true);

        builder.push("Liquid Collisions").categoryComment("Randomize the outcome of water/lava collisions");
        randomizeLiquidCollisions = builder.comment("Toggle liquid collisions.").define("randomizeLiquidCollisions", true);
        randomizeStoneGeneration = builder.comment("Whether to randomize the generation of blocks in place of stone.").define("randomizeStoneGeneration", true);
        randomizeObsidianGeneration = builder.comment("Whether to randomize the generation of blocks in place of obsidian.").define("randomizeObsidianGeneration", true);
        randomizeCobblestoneGeneration = builder.comment("Whether to randomize the generation of blocks in place of cobblestone.").define("randomizeCobblestoneGeneration", true);
        randomizeBasaltGeneration = builder.comment("Whether to randomize the generation of blocks in place of basalt.").define("randomizeBasaltGeneration", true);
        builder.pop();

        builder.push("Explosions").categoryComment("Randomize the outcome of explosions");
        randomizeExplosions = builder.comment("Toggle explosions.").define("randomizeExplosions", true);
        builder.pop();
        builder.build();
    }
}
