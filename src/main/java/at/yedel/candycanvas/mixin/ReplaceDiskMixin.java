package at.yedel.candycanvas.mixin;



import at.yedel.candycanvas.config.CandyConfig;
import at.yedel.candycanvas.utils.Candy;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.item.enchantment.Enchantable;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.effects.ReplaceDisk;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;



@Mixin(ReplaceDisk.class)
public abstract class ReplaceDiskMixin {
    @ModifyArg(method = "apply", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;setBlockAndUpdate(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Z"), index = 1)
    private BlockState candycanvas$replaceBlock(BlockState blockState, @Local EnchantedItemInUse item) {
        if (CandyConfig.getInstance().randomizeFrostWalker.get() && item.itemStack().getEnchantments().keySet().stream().anyMatch(holder -> holder.is(Enchantments.FROST_WALKER))) {
            return Candy.candyBlockState();
        }
        return blockState;
    }
}
