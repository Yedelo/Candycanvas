package at.yedel.candycasts.mixin;



import at.yedel.candycasts.Candy;
import at.yedel.candycasts.config.CandyConfig;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.LavaFluid;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;



@Mixin(LavaFluid.class)
public abstract class LavaFluidMixin {
    @ModifyExpressionValue(method = "spreadTo", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;STONE:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.GETSTATIC))
    private Block candycasts$randomizeStoneGeneration(Block original) {
        if (CandyConfig.getInstance().isEnabled() && CandyConfig.getInstance().shouldRandomizeStoneGeneration()) {
            return Candy.randomBlock();
        }
        return original;
    }
}
