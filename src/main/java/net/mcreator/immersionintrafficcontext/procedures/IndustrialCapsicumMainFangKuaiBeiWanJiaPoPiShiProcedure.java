package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;

public class IndustrialCapsicumMainFangKuaiBeiWanJiaPoPiShiProcedure {

	public static void execute(Level world, double x, double y, double z, BlockState blockstate) {
		BlockPos pos = BlockPos.containing(x, y, z);
		
		// 安全获取age属性值
		int age = 0;
		if (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty prop) {
			age = blockstate.getValue(prop);
		}
		
		// 判断是否成熟（age最大为3）
		if (age >= 3) {
			world.addFreshEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
					new ItemStack(net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModItems.INDUSTRIAL_CAPSICUM_1.get(), 5)));
		} else {
			world.addFreshEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
					new ItemStack(net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModItems.INDUSTRIAL_CAPSICUM_1.get(), 1)));
		}
	}
}