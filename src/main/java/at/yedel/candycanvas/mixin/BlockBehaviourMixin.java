package at.yedel.candycanvas.mixin;



import at.yedel.candycanvas.config.CandyConfig;
import at.yedel.candycanvas.utils.Candy;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;



@Mixin(BlockBehaviour.class)
public abstract class BlockBehaviourMixin {
    @ModifyArg(method = "onExplosionHit", at = @At(value = "INVOKE", target = /*? if >= 26.3 {*/ "Lnet/minecraft/server/level/ServerLevel;setBlockAndUpdate(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Z" /*?} else {*//*"Lnet/minecraft/server/level/ServerLevel;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z"*//*?}*/), index = 1)
    private BlockState candycanvas$randomizeExplosions(BlockState original) {
        if (CandyConfig.getInstance().enabled.get() && CandyConfig.getInstance().randomizeExplosions.get()) {
            return Candy.candyBlockState();
        }
        return original;
    }
}
