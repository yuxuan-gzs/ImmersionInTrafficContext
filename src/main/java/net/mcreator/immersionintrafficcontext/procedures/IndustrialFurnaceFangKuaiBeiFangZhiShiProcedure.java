package net.mcreator.immersionintrafficcontext.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.network.chat.Component;
import net.mcreator.immersionintrafficcontext.init.ImmersionInTrafficContextModBlocks;
import net.mcreator.immersionintrafficcontext.ImmersionInTrafficContextMod;

import java.util.ArrayList;
import java.util.List;

public class IndustrialFurnaceFangKuaiBeiFangZhiShiProcedure {
    
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        
        String errorMessage = checkStructureWithOrientation(world, x, y, z);
        
        if (errorMessage == null) {
            // 结构正确
            sendMessage(entity, "§a✓ Industrial Furnace structure complete!");
            
            // 给予成就（仅在服务端）
            if (entity instanceof ServerPlayer _player) {
                AdvancementHolder _adv = _player.server.getAdvancements()
                        .get(ResourceLocation.parse("immersion_in_traffic_context:coal_hog"));
                if (_adv != null) {
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
            }
        } else {
            // 结构错误
            sendMessage(entity, "§c✗ " + errorMessage);
            
            // 破坏方块并返还物品（仅在服务端执行方块操作）
            if (!world.isClientSide()) {
                world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE.get()).copy();
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }
            }
            
            ImmersionInTrafficContextMod.LOGGER.info("Industrial Furnace structure incomplete - item returned");
        }
    }
    
    /**
     * 安全发送消息（兼容服务端和客户端）
     */
    private static void sendMessage(Entity entity, String message) {
        if (entity instanceof Player _player) {
            _player.displayClientMessage(Component.literal(message), false);
        }
    }
    
    /**
     * 自动检测主方块朝向，然后检查 3x3x3 结构
     */
    private static String checkStructureWithOrientation(LevelAccessor world, double x, double y, double z) {
        int centerX = (int) x;
        int centerY = (int) y;
        int centerZ = (int) z;
        
        // 检测主方块朝向
        int[] direction = detectOrientation(world, centerX, centerY, centerZ);
        
        if (direction == null) {
            return "Cannot detect structure orientation! Place blocks behind the furnace.";
        }
        
        int dirX = direction[0];
        int dirY = direction[1];
        int dirZ = direction[2];
        
        ImmersionInTrafficContextMod.LOGGER.info("=== Structure Check ===");
        ImmersionInTrafficContextMod.LOGGER.info("Center: " + centerX + "," + centerY + "," + centerZ);
        ImmersionInTrafficContextMod.LOGGER.info("Direction: (" + dirX + "," + dirY + "," + dirZ + ")");
        
        // 根据朝向检查结构
        return checkStructureInDirection(world, centerX, centerY, centerZ, dirX, dirY, dirZ);
    }
    
    /**
     * 检测结构朝向
     */
    /**
 * 检测结构朝向
 * 找出哪个方向有完整的 3x3 墙面（说明结构在这个方向）
 */
    private static int[] detectOrientation(LevelAccessor world, int cx, int cy, int cz) {
        // 六个可能的方向
        int[][] directions = {
            {1, 0, 0},   // +X (东)
            {-1, 0, 0},  // -X (西)
            {0, 1, 0},   // +Y (上)
            {0, -1, 0},  // -Y (下)
            {0, 0, 1},   // +Z (南)
            {0, 0, -1}   // -Z (北)
        };
    
        int bestDirection = -1;
        int maxBricks = 0;
    
        // 检查每个方向，找出 Brick 最多的方向
        for (int i = 0; i < directions.length; i++) {
            int[] dir = directions[i];
            int dx = dir[0];
            int dy = dir[1];
            int dz = dir[2];
        
            int brickCount = 0;
        
            // 检查这个方向上的 3x3 墙面（距离为 1 的那一层）
            int[] perp1 = getPerpendicular1(dx, dy, dz);
            int[] perp2 = getPerpendicular2(dx, dy, dz);
        
            for (int p1 = -1; p1 <= 1; p1++) {
                for (int p2 = -1; p2 <= 1; p2++) {
                    // 跳过中心位置（那是 Tank 的位置）
                    if (p1 == 0 && p2 == 0) continue;
                    
                    int worldX = cx + dx + p1 * perp1[0] + p2 * perp2[0];
                    int worldY = cy + dy + p1 * perp1[1] + p2 * perp2[1];
                    int worldZ = cz + dz + p1 * perp1[2] + p2 * perp2[2];
                    
                    BlockPos pos = new BlockPos(worldX, worldY, worldZ);
                    var block = world.getBlockState(pos).getBlock();
                    
                    // 统计 Brick 数量
                    if (block == ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE_BRICK.get()) {
                        brickCount++;
                    }
                }
            }
        
            // 检查中心位置（Tank 应该在的位置）
            int tankX = cx + dx;
            int tankY = cy + dy;
            int tankZ = cz + dz;
            BlockPos tankPos = new BlockPos(tankX, tankY, tankZ);
            var tankBlock = world.getBlockState(tankPos).getBlock();
        
            if (tankBlock == ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE_TANK.get() ||
                tankBlock == ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE_BRICK.get()) {
                brickCount += 2; // 中心有方块，加分
            }
            
            ImmersionInTrafficContextMod.LOGGER.info("Direction " + i + " (" + dx + "," + dy + "," + dz + 
                                                    "): " + brickCount + " bricks");
            
            if (brickCount > maxBricks) {
                maxBricks = brickCount;
                bestDirection = i;
            }
        }
        
        // 至少需要 4 个 Brick 才认为结构在这个方向
        if (bestDirection != -1 && maxBricks >= 4) {
            return directions[bestDirection];
        }
    
        return null;
    }
    
    /**
     * 检查指定方向的结构
     * 主方块在 (cx, cy, cz)
     * Tank 在 (cx + dirX, cy + dirY, cz + dirZ) 正后方
     */
    private static String checkStructureInDirection(LevelAccessor world, int cx, int cy, int cz, 
                                                     int dirX, int dirY, int dirZ) {
        boolean hasTank = false;
        int brickCount = 0;
        int airCount = 0;
        int wrongBlockCount = 0;
        List<String> errors = new ArrayList<>();
        
        // 计算两个垂直向量
        int[] perp1 = getPerpendicular1(dirX, dirY, dirZ);
        int[] perp2 = getPerpendicular2(dirX, dirY, dirZ);
        
        // 遍历 3x3x3 范围
        for (int main = 0; main <= 2; main++) {
            for (int p1 = -1; p1 <= 1; p1++) {
                for (int p2 = -1; p2 <= 1; p2++) {
                    
                    // 计算世界坐标
                    int worldX = cx + main * dirX + p1 * perp1[0] + p2 * perp2[0];
                    int worldY = cy + main * dirY + p1 * perp1[1] + p2 * perp2[1];
                    int worldZ = cz + main * dirZ + p1 * perp1[2] + p2 * perp2[2];
                    
                    // 跳过主方块位置
                    if (main == 0 && p1 == 0 && p2 == 0) {
                        continue;
                    }
                    
                    BlockPos pos = new BlockPos(worldX, worldY, worldZ);
                    var block = world.getBlockState(pos).getBlock();
                    
                    // 判断是否是 Tank 位置（中间层的中心）
                    boolean isTankPosition = (main == 1 && p1 == 0 && p2 == 0);
                    
                    if (isTankPosition) {
                        if (block == ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE_TANK.get()) {
                            hasTank = true;
                        } else {
                            errors.add("Tank at [" + worldX + "," + worldY + "," + worldZ + "]");
                            if (block == Blocks.AIR.defaultBlockState().getBlock()) {
                                airCount++;
                            } else {
                                wrongBlockCount++;
                            }
                        }
                    } else {
                        if (block == ImmersionInTrafficContextModBlocks.INDUSTRIAL_FURNACE_BRICK.get()) {
                            brickCount++;
                        } else {
                            errors.add("Brick at [" + worldX + "," + worldY + "," + worldZ + "]");
                            if (block == Blocks.AIR.defaultBlockState().getBlock()) {
                                airCount++;
                            } else {
                                wrongBlockCount++;
                            }
                        }
                    }
                }
            }
        }
        
        // 输出日志
        ImmersionInTrafficContextMod.LOGGER.info("Tank: " + hasTank + " | Bricks: " + brickCount + 
                                                " | Air: " + airCount + " | Wrong: " + wrongBlockCount);
        
        // 验证结果
        if (!hasTank) {
            int tankX = cx + dirX;
            int tankY = cy + dirY;
            int tankZ = cz + dirZ;
            return "Missing Tank at [" + tankX + "," + tankY + "," + tankZ + "] (directly behind furnace)!";
        }
        if (airCount > 0) {
            return "Missing " + airCount + " blocks!";
        }
        if (wrongBlockCount > 0) {
            return "Wrong blocks detected! Use only Industrial Furnace Brick.";
        }
        
        return null;
    }
    
    private static int[] getPerpendicular1(int x, int y, int z) {
        if (x != 0) {
            return new int[]{0, 1, 0};
        } else if (y != 0) {
            return new int[]{1, 0, 0};
        } else {
            return new int[]{1, 0, 0};
        }
    }
    
    private static int[] getPerpendicular2(int x, int y, int z) {
        if (x != 0) {
            return new int[]{0, 0, 1};
        } else if (y != 0) {
            return new int[]{0, 0, 1};
        } else {
            return new int[]{0, 1, 0};
        }
    }
}