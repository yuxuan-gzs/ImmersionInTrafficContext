package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Items;

public class SolidPetroleumShuBiaoYouJianDanJiFangKuaiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		// 判断玩家主手是否持有打火石
		if (entity instanceof Player player) {
			ItemStack heldItem = player.getMainHandItem();
			if (heldItem.getItem() == Items.FLINT_AND_STEEL) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					_level.explode(null, x, y, z, Mth.nextInt(RandomSource.create(), 4, 13), Level.ExplosionInteraction.TNT);
				}
			}
		}
	}
}