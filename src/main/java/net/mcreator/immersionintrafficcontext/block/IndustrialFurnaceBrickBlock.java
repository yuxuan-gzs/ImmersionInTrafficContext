package net.mcreator.immersionintrafficcontext.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class IndustrialFurnaceBrickBlock extends Block {
	public IndustrialFurnaceBrickBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE_BRICKS).strength(2.1f, 11f).lightLevel(blockstate -> 1).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}