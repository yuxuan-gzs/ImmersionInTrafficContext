/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.immersionintrafficcontext.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.immersionintrafficcontext.block.*;
import net.mcreator.immersionintrafficcontext.ImmersionInTrafficContextMod;

import java.util.function.Function;

public class ImmersionInTrafficContextModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(ImmersionInTrafficContextMod.MODID);
	public static final DeferredBlock<Block> PETROLEUM = register("petroleum", PetroleumBlock::new);
	public static final DeferredBlock<Block> ASPHALT_MIXING_PLANT = register("asphalt_mixing_plant", AsphaltMixingPlantBlock::new);
	public static final DeferredBlock<Block> ROUGH_ASPHALT_BLOCK = register("rough_asphalt_block", RoughAsphaltBlockBlock::new);
	public static final DeferredBlock<Block> ASPHALT_ROAD_BLOCK = register("asphalt_road_block", AsphaltRoadBlockBlock::new);
	public static final DeferredBlock<Block> WHITE_ZEBRA_CROSSING = register("white_zebra_crossing", WhiteZebraCrossingBlock::new);
	public static final DeferredBlock<Block> JUNCTION_1 = register("junction_1", Junction1Block::new);
	public static final DeferredBlock<Block> JUNCTION_2 = register("junction_2", Junction2Block::new);
	public static final DeferredBlock<Block> JUNCTION_3 = register("junction_3", Junction3Block::new);
	public static final DeferredBlock<Block> ASPHALT_ROAD_BLOCK_ILLUMINATION_LIGHT = register("asphalt_road_block_illumination_light", AsphaltRoadBlockIlluminationLightBlock::new);
	public static final DeferredBlock<Block> BITUMINOUS_ORE = register("bituminous_ore", BituminousOreBlock::new);
	public static final DeferredBlock<Block> DUAL_YELLOW_ZEBRA_CROSSING = register("dual_yellow_zebra_crossing", DualYellowZebraCrossingBlock::new);
	public static final DeferredBlock<Block> LEFT_TURN_ASPHALT_PAVEMENT_BLOCK = register("left_turn_asphalt_pavement_block", LeftTurnAsphaltPavementBlockBlock::new);
	public static final DeferredBlock<Block> YELLOW_ZEBRA_CROSSING = register("yellow_zebra_crossing", YellowZebraCrossingBlock::new);
	public static final DeferredBlock<Block> STRAIGHT_AHEAD_ASPHALT_PAVEMENT_BLOCK = register("straight_ahead_asphalt_pavement_block", StraightAheadAsphaltPavementBlockBlock::new);
	public static final DeferredBlock<Block> RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK = register("right_turn_asphalt_pavement_block", RightTurnAsphaltPavementBlockBlock::new);
	public static final DeferredBlock<Block> ASPHALT_PAVEMENT_BLOCKS_FOR_LEFT_AND_RIGHT_TURNS = register("asphalt_pavement_blocks_for_left_and_right_turns", AsphaltPavementBlocksForLeftAndRightTurnsBlock::new);
	public static final DeferredBlock<Block> STRAIGHT_AHEAD_AND_LEFT_TURN_ASPHALT_PAVEMENT_BLOCK = register("straight_ahead_and_left_turn_asphalt_pavement_block", StraightAheadAndLeftTurnAsphaltPavementBlockBlock::new);
	public static final DeferredBlock<Block> STRAIGHT_AHEAD_AND_RIGHT_TURN_ASPHALT_PAVEMENT_BLOCK = register("straight_ahead_and_right_turn_asphalt_pavement_block", StraightAheadAndRightTurnAsphaltPavementBlockBlock::new);
	public static final DeferredBlock<Block> U_TURN_ASPHALT_PAVEMENT_BLOCK = register("u_turn_asphalt_pavement_block", UTurnAsphaltPavementBlockBlock::new);
	public static final DeferredBlock<Block> IRON_DRAWER_CABINET = register("iron_drawer_cabinet", IronDrawerCabinetBlock::new);
	public static final DeferredBlock<Block> LIQUID_BITUMEN = register("liquid_bitumen", LiquidBitumenBlock::new);
	public static final DeferredBlock<Block> HOT_1 = register("hot_1", Hot1Block::new);
	public static final DeferredBlock<Block> JGBKVHDMDRSJUDGJUPLSWQWQEZBNNJYJRWQWOI = register("jgbkvhdmdrsjudgjuplswqwqezbnnjyjrwqwoi", JgbkvhdmdrsjudgjuplswqwqezbnnjyjrwqwoiBlock::new);
	public static final DeferredBlock<Block> INCLINED_WHITE_CONCRETE_HALF_BRICK = register("inclined_white_concrete_half_brick", InclinedWhiteConcreteHalfBrickBlock::new);
	public static final DeferredBlock<Block> WHITE_CONCRETE_STONE_PILLAR = register("white_concrete_stone_pillar", WhiteConcreteStonePillarBlock::new);
	public static final DeferredBlock<Block> GRAY_CONCRETE_STONE_PILLAR = register("gray_concrete_stone_pillar", GrayConcreteStonePillarBlock::new);
	public static final DeferredBlock<Block> INCLINED_GRAY_CONCRETE_HALF_BRICK = register("inclined_gray_concrete_half_brick", InclinedGrayConcreteHalfBrickBlock::new);
	public static final DeferredBlock<Block> INDUSTRIAL_CAPSICUM = register("industrial_capsicum", IndustrialCapsicumBlock::new);
	public static final DeferredBlock<Block> INDUSTRIAL_FURNACE = register("industrial_furnace", IndustrialFurnaceBlock::new);
	public static final DeferredBlock<Block> INDUSTRIAL_FURNACE_BRICK = register("industrial_furnace_brick", IndustrialFurnaceBrickBlock::new);
	public static final DeferredBlock<Block> INDUSTRIAL_FURNACE_TANK = register("industrial_furnace_tank", IndustrialFurnaceTankBlock::new);
	public static final DeferredBlock<Block> ETHYLENE = register("ethylene", EthyleneBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier, BlockBehaviour.Properties.of());
	}
}