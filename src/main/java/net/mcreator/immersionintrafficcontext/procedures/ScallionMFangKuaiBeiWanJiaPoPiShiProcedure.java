package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModItems;

public class ScallionMFangKuaiBeiWanJiaPoPiShiProcedure {

	public static void execute(Level world, double x, double y, double z, BlockState blockstate) {
		BlockPos pos = BlockPos.containing(x, y, z);
		world.addFreshEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
				new ItemStack(ImmersionInTrafficContextModItems.SCALLION_MAIN.get(), 3 + new java.util.Random().nextInt(5))));
		world.addFreshEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
				new ItemStack(ImmersionInTrafficContextModItems.SPRING_ONION_SEEDS.get(), 1 + new java.util.Random().nextInt(4))));
	}
}