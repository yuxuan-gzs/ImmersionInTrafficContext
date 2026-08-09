package net.mcreator.immersionintrafficcontext.block;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.immersionintrafficcontext.procedures.SolidPetroleumShuBiaoYouJianDanJiFangKuaiShiProcedure;
import net.mcreator.immersionintrafficcontext.procedures.JgbkvhdmdrsjudgjuplswqwqezbnnjyjrwqwoiFangKuaiBeiFangZhiShiProcedure;

public class SolidPetroleumBlock extends Block {
	public SolidPetroleumBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(1f, 10f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).instrument(NoteBlockInstrument.CHIME));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 8;
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		if (world.getBestNeighborSignal(pos) > 0) {
			JgbkvhdmdrsjudgjuplswqwqezbnnjyjrwqwoiFangKuaiBeiFangZhiShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		}
		JgbkvhdmdrsjudgjuplswqwqezbnnjyjrwqwoiFangKuaiBeiFangZhiShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		JgbkvhdmdrsjudgjuplswqwqezbnnjyjrwqwoiFangKuaiBeiFangZhiShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}

	@Override
	public void wasExploded(Level world, BlockPos pos, Explosion e) {
		super.wasExploded(world, pos, e);
		JgbkvhdmdrsjudgjuplswqwqezbnnjyjrwqwoiFangKuaiBeiFangZhiShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void fallOn(Level world, BlockState blockstate, BlockPos pos, Entity entity, float distance) {
		super.fallOn(world, blockstate, pos, entity, distance);
		JgbkvhdmdrsjudgjuplswqwqezbnnjyjrwqwoiFangKuaiBeiFangZhiShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void onProjectileHit(Level world, BlockState blockstate, BlockHitResult hit, Projectile entity) {
		JgbkvhdmdrsjudgjuplswqwqezbnnjyjrwqwoiFangKuaiBeiFangZhiShiProcedure.execute(world, hit.getBlockPos().getX(), hit.getBlockPos().getY(), hit.getBlockPos().getZ());
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		//SolidPetroleumShuBiaoYouJianDanJiFangKuaiShiProcedure.execute(world, x, y, z);
        SolidPetroleumShuBiaoYouJianDanJiFangKuaiShiProcedure.execute(world, x, y, z, entity);//
		
		return InteractionResult.SUCCESS;
	}
}