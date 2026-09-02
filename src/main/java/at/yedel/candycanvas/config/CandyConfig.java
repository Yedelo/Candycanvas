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

    private Supplier<Boolean> enabled;
    private Supplier<Boolean> randomizeStoneGeneration;
    private Supplier<Boolean> randomizeObsidianGeneration;
    private Supplier<Boolean> randomizeCobblestoneGeneration;
    private Supplier<Boolean> randomizeBasaltGeneration;

    public void initialize() {
        IConfigBuilder builder = ConfigBuilders.newJsonConfig("candycanvas", "Candycanvas", false);
        enabled = builder.comment("Global toggle for the mod.").define("enabled", true);
        randomizeStoneGeneration = builder.comment("Whether to randomize the generation of blocks in place of stone.").define("randomizeStoneGeneration", true);
        randomizeObsidianGeneration = builder.comment("Whether to randomize the generation of blocks in place of obsidian.").define("randomizeObsidianGeneration", true);
        randomizeCobblestoneGeneration = builder.comment("Whether to randomize the generation of blocks in place of cobblestone.").define("randomizeCobblestoneGeneration", true);
        randomizeBasaltGeneration = builder.comment("Whether to randomize the generation of blocks in place of basalt.").define("randomizeBasaltGeneration", true);
        builder.build();
    }

    public boolean isEnabled() {
        return enabled.get();
    }

    public boolean shouldRandomizeStoneGeneration() {
        return randomizeStoneGeneration.get();
    }

    public boolean shouldRandomizeObsidianGeneration() {
        return randomizeObsidianGeneration.get();
    }

    public boolean shouldRandomizeCobblestoneGeneration() {
        return randomizeCobblestoneGeneration.get();
    }

    public boolean shouldRandomizeBasaltGeneration() {
        return randomizeBasaltGeneration.get();
    }
}
