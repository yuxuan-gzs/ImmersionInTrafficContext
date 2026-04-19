/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.immersionintrafficcontext.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.immersionintrafficcontext.block.entity.IronDrawerCabinetBlockEntity;
import net.mcreator.immersionintrafficcontext.block.entity.IndustrialFurnaceBlockEntity;
import net.mcreator.immersionintrafficcontext.block.entity.InclinedWhiteConcreteHalfBrickBlockEntity;
import net.mcreator.immersionintrafficcontext.block.entity.AsphaltMixingPlantBlockEntity;
import net.mcreator.immersionintrafficcontext.ImmersionInTrafficContextMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ImmersionInTrafficContextModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ImmersionInTrafficContextMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AsphaltMixingPlantBlockEntity>> ASPHALT_MIXING_PLANT = register("asphalt_mixing_plant", ImmersionInTrafficContextModBlocks.ASPHALT_MIXING_PLANT,
			AsphaltMixingPlantBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<IronDrawerCabinetBlockEntity>> IRON_DRAWER_CABINET = register("iron_drawer_cabinet", ImmersionInTrafficContextModBlocks.IRON_DRAWER_CABINET,
			IronDrawerCabinetBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<InclinedWhiteConcreteHalfBrickBlockEntity>> INCLINED_WHITE_CONCRETE_HALF_BRICK = register("inclined_white_concrete_half_brick",
			ImmersionInTrafficContextModBlocks.INCLINED_WHITE_CONCRETE_HALF_BRICK, InclinedWhiteConcreteHalfBrickBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<IndustrialFurnaceBlockEntity>> INDUSTRIAL_FURNACE = register("industrial_furnace", ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE, IndustrialFurnaceBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> new BlockEntityType(supplier, block.get()));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ASPHALT_MIXING_PLANT.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, IRON_DRAWER_CABINET.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, INCLINED_WHITE_CONCRETE_HALF_BRICK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, INDUSTRIAL_FURNACE.get(), SidedInvWrapper::new);
	}
}