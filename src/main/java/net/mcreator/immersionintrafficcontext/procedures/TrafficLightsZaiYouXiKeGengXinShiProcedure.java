package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import java.util.Calendar;

public class TrafficLightsZaiYouXiKeGengXinShiProcedure {

    // ========== NBT 键名常量 ==========
    private static final String NBT_SELECT = "Select";
    private static final String NBT_LV = "_lv";
    private static final String NBT_RED = "_red";
    private static final String NBT_YELL = "_yell";

    // 模式5 状态管理
    private static final String NBT_STATE = "state";           // 0=绿灯, 1=红灯, 2=黄灯
    private static final String NBT_PHASE_START = "phase_start"; // 当前阶段开始的绝对秒数

    // 缓存上次执行的秒数
    private static int lastSecond = -1;

    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.isClientSide()) return;

        int currentSecond = Calendar.getInstance().get(Calendar.SECOND);
        if (currentSecond == lastSecond) return;
        lastSecond = currentSecond;

        BlockPos pos = BlockPos.containing(x, y, z);
        double select = getBlockNBTNumber(world, pos, NBT_SELECT);

        if (select == 0) {
            handleMode0(world, pos);
        } else if (select == 30) {
            handleMode30(world, pos);
        } else if (select == 5) {
            handleMode5(world, pos);
        }
    }

    // ========== 模式0：固定循环 ==========
    private static void handleMode0(LevelAccessor world, BlockPos pos) {
        int second = Calendar.getInstance().get(Calendar.SECOND);
        int age;
        if (second < 31) {
            age = 2;
        } else if (second < 34) {
            age = 1;
        } else {
            age = 0;
        }
        setBlockAge(world, pos, age);
    }

    // ========== 模式30：固定循环 ==========
    private static void handleMode30(LevelAccessor world, BlockPos pos) {
        int second = Calendar.getInstance().get(Calendar.SECOND);
        int age;
        if (second < 34) {
            age = 0;
        } else if (second < 58) {
            age = 2;
        } else {
            age = 1;
        }
        setBlockAge(world, pos, age);
    }

    // ========== 模式5：可编程定时模式（最终修复版） ==========
    private static void handleMode5(LevelAccessor world, BlockPos pos) {
        // 获取用户设定的时间
        double lvTime = getBlockNBTNumber(world, pos, NBT_LV);
        double redTime = getBlockNBTNumber(world, pos, NBT_RED);
        double yellTime = getBlockNBTNumber(world, pos, NBT_YELL);

        if (lvTime <= 0 || redTime <= 0 || yellTime <= 0) {
            return;
        }

        // 获取当前绝对秒数（从0点开始）
        int currentTotalSeconds = getTotalSeconds();

        // ========== 获取当前状态 ==========
        double state = getBlockNBTNumber(world, pos, NBT_STATE);
        double phaseStart = getBlockNBTNumber(world, pos, NBT_PHASE_START);

        // 首次运行：初始化
        if (state < 0 || phaseStart < 0) {
            setBlockNBT(world, pos, NBT_STATE, 0.0);
            setBlockNBT(world, pos, NBT_PHASE_START, (double) currentTotalSeconds);
            setBlockAge(world, pos, 2); // 绿灯
            return;
        }

        int currentState = (int) state;

        // ========== 获取当前阶段的持续时间 ==========
        double currentPhaseDuration;
        if (currentState == 0) {
            currentPhaseDuration = lvTime;
        } else if (currentState == 1) {
            currentPhaseDuration = redTime;
        } else {
            currentPhaseDuration = yellTime;
        }

        // ========== 计算已过去的时间 ==========
        double elapsed = currentTotalSeconds - phaseStart;

        // ========== 判断是否需要切换 ==========
        if (elapsed >= currentPhaseDuration) {
            // 计算下一个状态
            int nextState = (currentState + 1) % 3;

            // 更新 NBT
            setBlockNBT(world, pos, NBT_STATE, (double) nextState);
            setBlockNBT(world, pos, NBT_PHASE_START, (double) currentTotalSeconds);

            // ========== 立即应用下一个阶段的灯光 ==========
            int age;
            if (nextState == 0) {
                age = 2;
            } else if (nextState == 1) {
                age = 0;
            } else {
                age = 1;
            }
            setBlockAge(world, pos, age);
        }
        // 如果还没到切换时间，保持当前灯光（什么都不做）
    }

    // ========== 工具方法 ==========

    private static int getTotalSeconds() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.HOUR_OF_DAY) * 3600 +
                cal.get(Calendar.MINUTE) * 60 +
                cal.get(Calendar.SECOND);
    }

    private static void setBlockAge(LevelAccessor world, BlockPos pos, int age) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty prop) {
            if (prop.getPossibleValues().contains(age)) {
                world.setBlock(pos, state.setValue(prop, age), 3);
            }
        }
    }

    private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null && blockEntity.getPersistentData().contains(tag)) {
            return blockEntity.getPersistentData().getDouble(tag);
        }
        return -1;
    }

    private static void setBlockNBT(LevelAccessor world, BlockPos pos, String key, double value) {
        if (world.isClientSide()) return;
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity == null) return;

        blockEntity.getPersistentData().putDouble(key, value);
        BlockState state = world.getBlockState(pos);
        if (world instanceof Level level) {
            level.sendBlockUpdated(pos, state, state, 3);
        }
    }
}