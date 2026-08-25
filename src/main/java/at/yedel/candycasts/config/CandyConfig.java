package at.yedel.candycasts.config;



public class CandyConfig {
    private static final CandyConfig INSTANCE = new CandyConfig();
    
    public static CandyConfig getInstance() {
        return INSTANCE;
    }
    
    private CandyConfig() {}

    private boolean shouldRandomizeStoneGeneration = true;
    private boolean shouldRandomizeCobblestoneGeneration = true;
    private boolean shouldRandomizeObsidianGeneration = true;
    private boolean shouldRandomizeBasaltGeneration = true;

    public void initialize() {

    }

    public boolean shouldRandomizeStoneGeneration() {
        return shouldRandomizeStoneGeneration;
    }

    public boolean shouldRandomizeCobblestoneGeneration() {
        return shouldRandomizeCobblestoneGeneration;
    }

    public boolean shouldRandomizeObsidianGeneration() {
        return shouldRandomizeObsidianGeneration;
    }

    public boolean shouldRandomizeBasaltGeneration() {
        return shouldRandomizeBasaltGeneration;
    }
}
