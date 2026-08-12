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
		BlockPos pos = BlockPos.containing(x, y, z);
		int currentSecond = Calendar.getInstance().get(Calendar.SECOND);
		int currentMinute = Calendar.getInstance().get(Calendar.MINUTE);
		int select = (int) getBlockNBTNumber(world, pos, "Select");
		
		if (select == 0) {
			// ========== 普通模式 ==========
			if (currentSecond >= 0 && currentSecond < 31) {
				setLightState(world, pos, 2);
			} else if (currentSecond >= 31 && currentSecond < 34) {
				setLightState(world, pos, 1);
			} else if (currentSecond >= 34 && currentSecond < 60) {
				setLightState(world, pos, 0);
			}
		} else if (select == 30) {
			// ========== 夜间模式 ==========
			if (currentSecond >= 58 && currentSecond < 60) {
				setLightState(world, pos, 1);
			} else if (currentSecond >= 34 && currentSecond < 58) {
				setLightState(world, pos, 2);
			} else if (currentSecond >= 0 && currentSecond < 34) {
				setLightState(world, pos, 0);
			}
		} else if (select == 5) {
			// ========== 自定义定时模式 ==========
			
			double _lv = getBlockNBTNumber(world, pos, "_lv");
			double _red = getBlockNBTNumber(world, pos, "_red");
			double _yell = getBlockNBTNumber(world, pos, "_yell");
			
			if (_lv <= 0 && _red <= 0 && _yell <= 0) {
				return;
			}
			
			double tagLv = getBlockNBTNumber(world, pos, "tagName_lv");
			double tagRed = getBlockNBTNumber(world, pos, "tagName_red");
			double tagYell = getBlockNBTNumber(world, pos, "tagName_yell");
			double minLvTime = getBlockNBTNumber(world, pos, "min_lv_time");
			double minRedTime = getBlockNBTNumber(world, pos, "min_red_time");
			double minYellTime = getBlockNBTNumber(world, pos, "min_yell_time");
			double sLv = getBlockNBTNumber(world, pos, "s_lv");
			double sRed = getBlockNBTNumber(world, pos, "s_red");
			double sYell = getBlockNBTNumber(world, pos, "s_yell");
			double timeLv = getBlockNBTNumber(world, pos, "time_lv");
			
			// ============================================================
			// ✅ 核心逻辑：检查是否需要"追赶"（退出重进后时间已过期）
			// ============================================================
			boolean needCatchUp = false;
			double targetMinute = -1;
			double targetSecond = -1;
			int currentState = -1;
			int nextState = -1;
			
			if (tagLv == 1 && tagRed == 0 && tagYell == 0) {
				targetMinute = minLvTime;
				targetSecond = sLv;
				currentState = 2;
				nextState = 1;
				if (targetMinute >= 0) {
					if (currentMinute > targetMinute || (currentMinute == targetMinute && currentSecond > targetSecond)) {
						needCatchUp = true;
					}
				}
			} else if (tagLv == 2 && tagYell == 1 && tagRed == 0) {
				targetMinute = minYellTime;
				targetSecond = sYell;
				currentState = 1;
				nextState = 0;
				if (targetMinute >= 0) {
					if (currentMinute > targetMinute || (currentMinute == targetMinute && currentSecond > targetSecond)) {
						needCatchUp = true;
					}
				}
			} else if (tagYell == 2 && tagRed == 1) {
				targetMinute = minRedTime;
				targetSecond = sRed;
				currentState = 0;
				nextState = 2;
				if (targetMinute >= 0) {
					if (currentMinute > targetMinute || (currentMinute == targetMinute && currentSecond > targetSecond)) {
						needCatchUp = true;
					}
				}
			}
			
			// ============================================================
			// ✅ 如果需要"追赶"，计算当前应该处于什么状态
			// ============================================================
			if (needCatchUp && targetMinute >= 0) {
				double totalCycle = _lv + _yell + _red;
				
				double exitTargetSeconds = targetMinute * 60 + targetSecond;
				double currentTotalSeconds = currentMinute * 60 + currentSecond;
				
				if (currentTotalSeconds < exitTargetSeconds) {
					currentTotalSeconds += 24 * 60 * 60;
				}
				
				double diffSeconds = currentTotalSeconds - exitTargetSeconds;
				double position = diffSeconds % totalCycle;
				
				int lightState;
				double remaining = 0;
				
				if (position < _yell) {
					lightState = 1;
					remaining = _yell - position;
				} else if (position < _yell + _red) {
					lightState = 0;
					remaining = _yell + _red - position;
				} else {
					lightState = 2;
					remaining = totalCycle - position;
				}
				
				setLightState(world, pos, lightState);
				
				if (!world.isClientSide()) {
					BlockPos _bp = pos;
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						double nextSwitchSeconds = currentSecond + remaining;
						double nextSwitchMinute = currentMinute;
						while (nextSwitchSeconds >= 60) {
							nextSwitchSeconds -= 60;
							nextSwitchMinute += 1;
						}
						while (nextSwitchMinute >= 60) {
							nextSwitchMinute -= 60;
						}
						
						if (lightState == 2) {
							if (remaining > 0) {
								_blockEntity.getPersistentData().putDouble("s_lv", nextSwitchSeconds);
								_blockEntity.getPersistentData().putDouble("min_lv_time", nextSwitchMinute);
							}
							_blockEntity.getPersistentData().putDouble("tagName_lv", 1);
							_blockEntity.getPersistentData().putDouble("tagName_red", 0);
							_blockEntity.getPersistentData().putDouble("tagName_yell", 0);
							_blockEntity.getPersistentData().putDouble("time_lv", (double) currentSecond);
						} else if (lightState == 1) {
							_blockEntity.getPersistentData().putDouble("s_yell", nextSwitchSeconds);
							_blockEntity.getPersistentData().putDouble("min_yell_time", nextSwitchMinute);
							_blockEntity.getPersistentData().putDouble("tagName_lv", 2);
							_blockEntity.getPersistentData().putDouble("tagName_red", 0);
							_blockEntity.getPersistentData().putDouble("tagName_yell", 1);
						} else {
							_blockEntity.getPersistentData().putDouble("s_red", nextSwitchSeconds);
							_blockEntity.getPersistentData().putDouble("min_red_time", nextSwitchMinute);
							_blockEntity.getPersistentData().putDouble("tagName_lv", 2);
							_blockEntity.getPersistentData().putDouble("tagName_red", 1);
							_blockEntity.getPersistentData().putDouble("tagName_yell", 2);
						}
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				return;
			}
			
			// ============================================================
			// 以下为正常状态机逻辑
			// ============================================================
			
			// ----- 阶段0：初始化绿灯时间计算 -----
			if (getBlockNBTNumber(world, pos, "tagName_lv") == 0) {
				if (getBlockNBTNumber(world, pos, "time_lv") + getBlockNBTNumber(world, pos, "_lv") >= 60) {
					if (!world.isClientSide()) {
						BlockPos _bp = pos;
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							double min_lv = Math.floor((getBlockNBTNumber(world, pos, "time_lv") + getBlockNBTNumber(world, pos, "_lv")) / 60);
							double s_lv = (getBlockNBTNumber(world, pos, "time_lv") + getBlockNBTNumber(world, pos, "_lv")) - min_lv * 60;
							double targetMinute2 = currentMinute + min_lv;
							while (targetMinute2 >= 60) {
								targetMinute2 -= 60;
							}
							_blockEntity.getPersistentData().putDouble("min_lv", min_lv);
							_blockEntity.getPersistentData().putDouble("s_lv", s_lv);
							_blockEntity.getPersistentData().putDouble("min_lv_time", targetMinute2);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = pos;
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("s_lv", getBlockNBTNumber(world, pos, "time_lv") + getBlockNBTNumber(world, pos, "_lv"));
							_blockEntity.getPersistentData().putDouble("min_lv_time", (double) currentMinute);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = pos;
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("tagName_lv", 1);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			
			// ----- 阶段1：绿灯→黄灯切换 -----
			if (getBlockNBTNumber(world, pos, "tagName_lv") == 1 
				&& getBlockNBTNumber(world, pos, "tagName_red") == 0
				&& getBlockNBTNumber(world, pos, "tagName_yell") == 0) {
				
				if (currentMinute == getBlockNBTNumber(world, pos, "min_lv_time")
					&& currentSecond == getBlockNBTNumber(world, pos, "s_lv")) {
					
					setLightState(world, pos, 1);
					
					if (!world.isClientSide()) {
						BlockPos _bp = pos;
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							double time_yell = currentSecond;
							double _yell2 = getBlockNBTNumber(world, pos, "_yell");
							double target_yell = time_yell + _yell2;
							
							if (target_yell >= 60) {
								_blockEntity.getPersistentData().putDouble("min_yell", Math.floor(target_yell / 60));
								_blockEntity.getPersistentData().putDouble("s_yell", target_yell % 60);
								double targetMinute3 = currentMinute + Math.floor(target_yell / 60);
								while (targetMinute3 >= 60) {
									targetMinute3 -= 60;
								}
								_blockEntity.getPersistentData().putDouble("min_yell_time", targetMinute3);
							} else {
								_blockEntity.getPersistentData().putDouble("s_yell", target_yell);
								_blockEntity.getPersistentData().putDouble("min_yell_time", (double) currentMinute);
							}
							
							_blockEntity.getPersistentData().putDouble("tagName_yell", 1);
							_blockEntity.getPersistentData().putDouble("tagName_lv", 2);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
			
			// ----- 阶段2：黄灯→红灯切换 -----
			if (getBlockNBTNumber(world, pos, "tagName_lv") == 2 
				&& getBlockNBTNumber(world, pos, "tagName_yell") == 1
				&& getBlockNBTNumber(world, pos, "tagName_red") == 0) {
				
				double minYellTime2 = getBlockNBTNumber(world, pos, "min_yell_time");
				if (minYellTime2 >= 0) {
					if (currentMinute == minYellTime2
						&& currentSecond == getBlockNBTNumber(world, pos, "s_yell")) {
						
						setLightState(world, pos, 0);
						
						if (!world.isClientSide()) {
							BlockPos _bp = pos;
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								double time_red = currentSecond;
								double _red2 = getBlockNBTNumber(world, pos, "_red");
								double target_red = time_red + _red2;
								
								if (target_red >= 60) {
									_blockEntity.getPersistentData().putDouble("min_red", Math.floor(target_red / 60));
									_blockEntity.getPersistentData().putDouble("s_red", target_red % 60);
									double targetMinute4 = currentMinute + Math.floor(target_red / 60);
									while (targetMinute4 >= 60) {
										targetMinute4 -= 60;
									}
									_blockEntity.getPersistentData().putDouble("min_red_time", targetMinute4);
								} else {
									_blockEntity.getPersistentData().putDouble("s_red", target_red);
									_blockEntity.getPersistentData().putDouble("min_red_time", (double) currentMinute);
								}
								
								_blockEntity.getPersistentData().putDouble("tagName_red", 1);
								_blockEntity.getPersistentData().putDouble("tagName_yell", 2);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			}
			
			// ----- 阶段3：红灯→绿灯切换（完成循环） -----
			if (getBlockNBTNumber(world, pos, "tagName_yell") == 2 
				&& getBlockNBTNumber(world, pos, "tagName_red") == 1) {
				
				double minRedTime2 = getBlockNBTNumber(world, pos, "min_red_time");
				if (minRedTime2 >= 0) {
					if (currentMinute == minRedTime2
						&& currentSecond == getBlockNBTNumber(world, pos, "s_red")) {
						
						setLightState(world, pos, 2);
						
						if (!world.isClientSide()) {
							BlockPos _bp = pos;
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("time_lv", (double) currentSecond);
								_blockEntity.getPersistentData().putDouble("tagName_lv", 0);
								_blockEntity.getPersistentData().putDouble("tagName_red", 0);
								_blockEntity.getPersistentData().putDouble("tagName_yell", 0);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			}
		}
	}
	
	// ========== 辅助方法 ==========
	
	private static void setLightState(LevelAccessor world, BlockPos pos, int value) {
		BlockState _bs = world.getBlockState(pos);
		if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp 
				&& _integerProp.getPossibleValues().contains(value)) {
			world.setBlock(pos, _bs.setValue(_integerProp, value), 3);
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}