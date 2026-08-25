package at.yedel.candycasts;

import java.util.List;
import java.util.Random;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class Candy {
    private static final List<Block> blocks;

    private static final Random random = new Random();

    static {
        blocks = BuiltInRegistries.BLOCK.stream().toList();
    }

    public static Block randomBlock() {
        return blocks.get(random.nextInt(blocks.size()));
    }

    public static BlockState randomBlockState() {
        return randomBlock().defaultBlockState();
    }
}
