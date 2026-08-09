package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class IndustrialCapsicumMainGuFenShiYongChengGongDeTiaoJianProcedure {
	public static boolean execute() {
		if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
			return true;
		}
		return false;
	}
}