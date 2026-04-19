package net.mcreator.immersionintrafficcontext.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModItems;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModFluids;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModFluidTypes;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModBlocks;

public abstract class EthyleneFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> ImmersionInTrafficContextModFluidTypes.ETHYLENE_TYPE.get(), () -> ImmersionInTrafficContextModFluids.ETHYLENE.get(),
			() -> ImmersionInTrafficContextModFluids.FLOWING_ETHYLENE.get()).explosionResistance(100f).tickRate(7).slopeFindDistance(9).bucket(() -> ImmersionInTrafficContextModItems.ETHYLENE_BUCKET.get())
			.block(() -> (LiquidBlock) ImmersionInTrafficContextModBlocks.ETHYLENE.get());

	private EthyleneFluid() {
		super(PROPERTIES);
	}

	public static class Source extends EthyleneFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends EthyleneFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}