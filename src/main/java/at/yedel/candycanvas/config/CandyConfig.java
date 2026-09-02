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
    private Supplier<Boolean> shouldRandomizeStoneGeneration;
    private Supplier<Boolean> shouldRandomizeObsidianGeneration;
    private Supplier<Boolean> shouldRandomizeCobblestoneGeneration;
    private Supplier<Boolean> shouldRandomizeBasaltGeneration;

    public void initialize() {
        IConfigBuilder builder = ConfigBuilders.newJsonConfig("candycanvas", "Candycanvas", false);
        enabled = builder.comment("Global toggle for the mod.").define("enabled", true);
        shouldRandomizeStoneGeneration = builder.comment("Whether to randomize the generation of blocks in place of stone.").define("shouldRandomizeStoneGeneration", true);
        shouldRandomizeObsidianGeneration = builder.comment("Whether to randomize the generation of blocks in place of obsidian.").define("shouldRandomizeObsidianGeneration", true);
        shouldRandomizeCobblestoneGeneration = builder.comment("Whether to randomize the generation of blocks in place of cobblestone.").define("shouldRandomizeCobblestoneGeneration", true);
        shouldRandomizeBasaltGeneration = builder.comment("Whether to randomize the generation of blocks in place of basalt.").define("shouldRandomizeBasaltGeneration", true);
        builder.build();
    }

    public boolean isEnabled() {
        return enabled.get();
    }

    public boolean shouldRandomizeStoneGeneration() {
        return shouldRandomizeStoneGeneration.get();
    }

    public boolean shouldRandomizeObsidianGeneration() {
        return shouldRandomizeObsidianGeneration.get();
    }

    public boolean shouldRandomizeCobblestoneGeneration() {
        return shouldRandomizeCobblestoneGeneration.get();
    }

    public boolean shouldRandomizeBasaltGeneration() {
        return shouldRandomizeBasaltGeneration.get();
    }
}
