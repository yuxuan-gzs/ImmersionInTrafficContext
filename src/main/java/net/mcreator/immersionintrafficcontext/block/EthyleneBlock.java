package net.mcreator.immersionintrafficcontext.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModFluids;

public class EthyleneBlock extends LiquidBlock {
	public EthyleneBlock(BlockBehaviour.Properties properties) {
		super(ImmersionInTrafficContextModFluids.ETHYLENE.get(), properties.mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}
}