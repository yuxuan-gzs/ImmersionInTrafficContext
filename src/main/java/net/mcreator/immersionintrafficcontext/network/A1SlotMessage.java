package net.mcreator.immersionintrafficcontext.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

import net.mcreator.immersionintrafficcontext.procedures.XcbmProcedure;
import net.mcreator.immersionintrafficcontext.ImmersionInTrafficContextMod;

@EventBusSubscriber
public record A1SlotMessage(int slotID, int x, int y, int z, int changeType, int meta) implements CustomPacketPayload {
	public static final Type<A1SlotMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ImmersionInTrafficContextMod.MODID, "a_1_slots"));
	public static final StreamCodec<RegistryFriendlyByteBuf, A1SlotMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, A1SlotMessage message) -> {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}, (RegistryFriendlyByteBuf buffer) -> new A1SlotMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<A1SlotMessage> type() {
		return TYPE;
	}

	public static void handleData(final A1SlotMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleSlotAction(context.player(), message.slotID, message.changeType, message.meta, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (slot == 0 && changeType == 0) {

			XcbmProcedure.execute(world, x, y, z);
		}
		if (slot == 2 && changeType == 0) {

			XcbmProcedure.execute(world, x, y, z);
		}
		if (slot == 6 && changeType == 0) {

			XcbmProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ImmersionInTrafficContextMod.addNetworkMessage(A1SlotMessage.TYPE, A1SlotMessage.STREAM_CODEC, A1SlotMessage::handleData);
	}
}