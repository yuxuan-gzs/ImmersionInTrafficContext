package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import java.util.Calendar;

public class TrafficLightsZaiYouXiKeGengXinShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Select") == 0) {
			if (Calendar.getInstance().get(Calendar.SECOND) >= 0 && Calendar.getInstance().get(Calendar.SECOND) < 31) {
				{
					int _value = 2;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			} else if (Calendar.getInstance().get(Calendar.SECOND) >= 31 && Calendar.getInstance().get(Calendar.SECOND) < 34) {
				{
					int _value = 1;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			} else if (Calendar.getInstance().get(Calendar.SECOND) >= 34 && Calendar.getInstance().get(Calendar.SECOND) < 61) {
				{
					int _value = 0;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			}
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Select") == 30) {
			if (Calendar.getInstance().get(Calendar.SECOND) >= 58 && Calendar.getInstance().get(Calendar.SECOND) < 61) {
				{
					int _value = 1;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			} else if (Calendar.getInstance().get(Calendar.SECOND) >= 34 && Calendar.getInstance().get(Calendar.SECOND) < 58) {
				{
					int _value = 2;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			} else if (Calendar.getInstance().get(Calendar.SECOND) >= 0 && Calendar.getInstance().get(Calendar.SECOND) < 34) {
				{
					int _value = 0;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			}
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Select") == 5) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "_lv") <= 0) {
				return;
			}

			boolean executed = false;

			// 阶段0：初始化绿灯时间计算
			if (!executed && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tagName_lv") == 0) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "time_lv") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "_lv") >= 60) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("min_lv", Math.floor((getBlockNBTNumber(world, BlockPos.containing(x, y, z), "time_lv") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "_lv")) / 60));
							_blockEntity.getPersistentData().putDouble("s_lv",
									((getBlockNBTNumber(world, BlockPos.containing(x, y, z), "time_lv") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "_lv")) - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "min_lv") * 60));
							_blockEntity.getPersistentData().putDouble("min_lv_time", Calendar.getInstance().get(Calendar.MINUTE));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "min_lv_time") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "min_lv") >= 60) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("min_lv_time", ((getBlockNBTNumber(world, BlockPos.containing(x, y, z), "min_lv_time") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "min_lv")) - 60));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("s_lv", getBlockNBTNumber(world, BlockPos.containing(x, y, z), "time_lv") + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "_lv"));
							_blockEntity.getPersistentData().putDouble("min_lv_time", Calendar.getInstance().get(Calendar.MINUTE));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("tagName_lv", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				executed = true;
			}

			// 阶段1：绿灯→黄灯切换
			if (!executed && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tagName_lv") == 1
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tagName_red") == 0
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tagName_yell") == 0) {

				if (Calendar.getInstance().get(Calendar.MINUTE) == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "min_lv_time")
						&& Calendar.getInstance().get(Calendar.SECOND) == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "s_lv")) {

					{
						int _value = 1;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}

					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							double time_yell = Calendar.getInstance().get(Calendar.SECOND);
							double _yell = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "_yell");
							double target_yell = time_yell + _yell;

							if (target_yell >= 60) {
								int addMinutes = (int) Math.floor(target_yell / 60);
								_blockEntity.getPersistentData().putDouble("min_yell", addMinutes);
								_blockEntity.getPersistentData().putDouble("s_yell", target_yell % 60);
								int newMinute = Calendar.getInstance().get(Calendar.MINUTE) + addMinutes;
								if (newMinute >= 60) {
									newMinute = newMinute - 60;
								}
								_blockEntity.getPersistentData().putDouble("min_yell_time", newMinute);
							} else {
								_blockEntity.getPersistentData().putDouble("s_yell", target_yell);
								_blockEntity.getPersistentData().putDouble("min_yell_time", Calendar.getInstance().get(Calendar.MINUTE));
							}

							_blockEntity.getPersistentData().putDouble("tagName_yell", 1);
							_blockEntity.getPersistentData().putDouble("tagName_lv", 2);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					executed = true;
				}
			}

			// 阶段2：黄灯→红灯切换
			if (!executed && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tagName_lv") == 2
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tagName_yell") == 1
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tagName_red") == 0) {

				double minYellTime = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "min_yell_time");
				if (minYellTime >= 0) {
					if (Calendar.getInstance().get(Calendar.MINUTE) == minYellTime
							&& Calendar.getInstance().get(Calendar.SECOND) == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "s_yell")) {

						{
							int _value = 0;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}

						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								double time_red = Calendar.getInstance().get(Calendar.SECOND);
								double _red = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "_red");
								double target_red = time_red + _red;

								if (target_red >= 60) {
									int addMinutes = (int) Math.floor(target_red / 60);
									_blockEntity.getPersistentData().putDouble("min_red", addMinutes);
									_blockEntity.getPersistentData().putDouble("s_red", target_red % 60);
									int newMinute = Calendar.getInstance().get(Calendar.MINUTE) + addMinutes;
									if (newMinute >= 60) {
										newMinute = newMinute - 60;
									}
									_blockEntity.getPersistentData().putDouble("min_red_time", newMinute);
								} else {
									_blockEntity.getPersistentData().putDouble("s_red", target_red);
									_blockEntity.getPersistentData().putDouble("min_red_time", Calendar.getInstance().get(Calendar.MINUTE));
								}

								_blockEntity.getPersistentData().putDouble("tagName_red", 1);
								_blockEntity.getPersistentData().putDouble("tagName_yell", 2);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						executed = true;
					}
				}
			}

			// 阶段3：红灯→绿灯切换
			if (!executed && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tagName_yell") == 2
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tagName_red") == 1) {

				double minRedTime = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "min_red_time");
				if (minRedTime >= 0) {
					if (Calendar.getInstance().get(Calendar.MINUTE) == minRedTime
							&& Calendar.getInstance().get(Calendar.SECOND) == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "s_red")) {

						{
							int _value = 2;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}

						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("time_lv", Calendar.getInstance().get(Calendar.SECOND));
								_blockEntity.getPersistentData().putDouble("tagName_lv", 0);
								_blockEntity.getPersistentData().putDouble("tagName_red", 0);
								_blockEntity.getPersistentData().putDouble("tagName_yell", 0);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						executed = true;
					}
				}
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}