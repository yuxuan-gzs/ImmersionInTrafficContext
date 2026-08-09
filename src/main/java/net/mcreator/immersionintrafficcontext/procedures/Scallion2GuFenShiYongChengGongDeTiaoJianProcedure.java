package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class Scallion2GuFenShiYongChengGongDeTiaoJianProcedure {
	public static boolean execute() {
		if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
			return true;
		}
		return false;
	}
}