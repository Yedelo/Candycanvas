package at.yedel.candycasts.mixin;



import at.yedel.candycasts.Candy;
import at.yedel.candycasts.config.CandyConfig;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;



@Mixin(LiquidBlock.class)
public abstract class LiquidBlockMixin {
    @ModifyExpressionValue(method = "shouldSpreadLiquid", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;OBSIDIAN:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.GETSTATIC))
    private Block candycasts$randomizeObsidianGeneration(Block original) {
        if (CandyConfig.getInstance().isEnabled() && CandyConfig.getInstance().shouldRandomizeObsidianGeneration()) {
            return Candy.randomBlock();
        }
        return original;
    }

    @ModifyExpressionValue(method = "shouldSpreadLiquid", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;COBBLESTONE:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.GETSTATIC))
    private Block candycasts$randomizeCobblestoneGeneration(Block original) {
        if (CandyConfig.getInstance().isEnabled() && CandyConfig.getInstance().shouldRandomizeCobblestoneGeneration()) {
            return Candy.randomBlock();
        }
        return original;
    }

    @ModifyExpressionValue(method = "shouldSpreadLiquid", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;BASALT:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.GETSTATIC))
    private Block candycasts$randomizeBasaltGeneration(Block original) {
        if (CandyConfig.getInstance().isEnabled() && CandyConfig.getInstance().shouldRandomizeBasaltGeneration()) {
            return Candy.randomBlock();
        }
        return original;
    }
}
