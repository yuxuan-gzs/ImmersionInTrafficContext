package net.mcreator.immersionintrafficcontext.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.core.BlockPos;

public class BituminousOreBlock extends Block {
	public BituminousOreBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(1.05f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos) {
		return 0.4f;
	}
}