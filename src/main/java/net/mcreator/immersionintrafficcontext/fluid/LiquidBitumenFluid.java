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

public abstract class LiquidBitumenFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> ImmersionInTrafficContextModFluidTypes.LIQUID_BITUMEN_TYPE.get(), () -> ImmersionInTrafficContextModFluids.LIQUID_BITUMEN.get(),
			() -> ImmersionInTrafficContextModFluids.FLOWING_LIQUID_BITUMEN.get()).explosionResistance(101f).tickRate(35).slopeFindDistance(6).bucket(() -> ImmersionInTrafficContextModItems.LIQUID_BITUMEN_BUCKET.get())
			.block(() -> (LiquidBlock) ImmersionInTrafficContextModBlocks.LIQUID_BITUMEN.get());

	private LiquidBitumenFluid() {
		super(PROPERTIES);
	}

	public static class Source extends LiquidBitumenFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends LiquidBitumenFluid {
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