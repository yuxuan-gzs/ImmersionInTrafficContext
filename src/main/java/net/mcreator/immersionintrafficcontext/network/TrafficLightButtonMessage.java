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

import net.mcreator.immersionintrafficcontext.procedures.*;
import net.mcreator.immersionintrafficcontext.ImmersionInTrafficContextMod;

@EventBusSubscriber
public record TrafficLightButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<TrafficLightButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ImmersionInTrafficContextMod.MODID, "traffic_light_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, TrafficLightButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, TrafficLightButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new TrafficLightButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<TrafficLightButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final TrafficLightButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			X0000x11Procedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			X0000x10Procedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			Custom1Procedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			GUILv1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			GUILv2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			GUIred1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			GUIred2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			GUIyell1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			GUIyell2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			Lv1Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ImmersionInTrafficContextMod.addNetworkMessage(TrafficLightButtonMessage.TYPE, TrafficLightButtonMessage.STREAM_CODEC, TrafficLightButtonMessage::handleData);
	}
}