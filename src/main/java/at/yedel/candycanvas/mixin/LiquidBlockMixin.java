package at.yedel.candycanvas.mixin;



import at.yedel.candycanvas.utils.Candy;
import at.yedel.candycanvas.config.CandyConfig;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;



@Mixin(LiquidBlock.class)
public abstract class LiquidBlockMixin {
    @ModifyExpressionValue(method = "shouldSpreadLiquid", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;OBSIDIAN:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.GETSTATIC))
    private Block candycanvas$randomizeObsidianGeneration(Block original) {
        if (CandyConfig.getInstance().enabled.get() && CandyConfig.getInstance().liquidCollisions.get() && CandyConfig.getInstance().randomizeObsidianGeneration.get()) {
            return Candy.randomBlock();
        }
        return original;
    }

    @ModifyExpressionValue(method = "shouldSpreadLiquid", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;COBBLESTONE:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.GETSTATIC))
    private Block candycanvas$randomizeCobblestoneGeneration(Block original) {
        if (CandyConfig.getInstance().enabled.get() && CandyConfig.getInstance().liquidCollisions.get() && CandyConfig.getInstance().randomizeCobblestoneGeneration.get()) {
            return Candy.randomBlock();
        }
        return original;
    }

    @ModifyExpressionValue(method = "shouldSpreadLiquid", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;BASALT:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.GETSTATIC))
    private Block candycanvas$randomizeBasaltGeneration(Block original) {
        if (CandyConfig.getInstance().enabled.get() && CandyConfig.getInstance().liquidCollisions.get() && CandyConfig.getInstance().randomizeBasaltGeneration.get()) {
            return Candy.randomBlock();
        }
        return original;
    }
}
