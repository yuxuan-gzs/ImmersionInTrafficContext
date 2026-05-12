package net.mcreator.immersionintrafficcontext.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModBlocks;

import java.util.concurrent.atomic.AtomicInteger;

public class IndustrialChiliPepperPlant1FangKuaiBeiShiTiFangZhiShiProcedure {
    
    // 延迟时间（ticks），3分钟 = 3600 ticks
    private static final int DELAY_TICKS = 3600;
    
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.isClientSide()) return;
        
        ServerLevel serverWorld = (ServerLevel) world;
        BlockPos pos = BlockPos.containing(x, y, z);
        
        // 方案2A：使用 scheduleTick 调度方块更新
        serverWorld.scheduleTick(pos, 
            serverWorld.getBlockState(pos).getBlock(), 
            DELAY_TICKS);
        
        // 或者方案2B：使用 BlockEntity 计时（需要配合方块实体）
        // scheduleBlockEntityTick(serverWorld, pos);
    }
    
    // 配合方块实体使用的计时方法
    public static void delayedReplace(LevelAccessor world, double x, double y, double z) {
        if (world.isClientSide()) return;
        
        ServerLevel serverWorld = (ServerLevel) world;
        BlockPos pos = BlockPos.containing(x, y, z);
        
        replaceBlock(serverWorld, pos);
    }
    
    public static void replaceBlock(ServerLevel world, BlockPos pos) {
        BlockState currentState = world.getBlockState(pos);
        
        // 检查方块是否已被替换或破坏
        if (currentState.isAir()) return;
        
        BlockState newState = ImmersionInTrafficContextModBlocks.INDUSTRIAL_CAPSICUM.get().defaultBlockState();
        
        // 保留原方块的部分属性（如朝向、水分等）
        for (Property<?> oldProp : currentState.getProperties()) {
            Property<?> newProp = newState.getBlock().getStateDefinition().getProperty(oldProp.getName());
            if (newProp != null) {
                try {
                    newState = copyStateProperty(currentState, newState, oldProp, newProp);
                } catch (Exception ignored) {}
            }
        }
        
        // 替换方块，保留原方块的 BlockEntity 数据（可选）
        world.setBlock(pos, newState, Block.UPDATE_ALL);
        
        // 如果需要保留原方块实体的数据，可以在此处复制
        // BlockEntity oldEntity = world.getBlockEntity(pos);
        // if (oldEntity != null) {
        //     BlockEntity newEntity = world.getBlockEntity(pos);
        //     if (newEntity != null) {
        //         newEntity.load(oldEntity.saveWithFullMetadata());
        //     }
        // }
    }
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    private static BlockState copyStateProperty(BlockState oldState, BlockState newState,
                                                 Property<?> oldProp, Property<?> newProp) {
        Property typedNew = (Property) newProp;
        Property typedOld = (Property) oldProp;
        Comparable value = oldState.getValue(typedOld);
        if (typedNew.getPossibleValues().contains(value)) {
            return newState.setValue(typedNew, value);
        }
        return newState;
    }
}