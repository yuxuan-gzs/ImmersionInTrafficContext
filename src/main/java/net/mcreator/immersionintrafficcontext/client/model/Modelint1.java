package net.mcreator.immersionintrafficcontext.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelint1<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("immersion_in_traffic_context", "modelint_1"), "main");
	public final ModelPart bb_main;

	public Modelint1(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(32, 9).addBox(-8.0F, -8.0F, -8.0F, 15.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 9).addBox(-8.0F, -8.0F, -8.0F, 1.0F, 8.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(0, 32)
						.addBox(-7.0F, -8.0F, -7.0F, 7.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(32, 18).addBox(0.0F, -8.0F, -7.0F, 6.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 27)
						.addBox(0.0F, -8.0F, -6.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(44, 27).addBox(0.0F, -8.0F, -3.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(46, 0)
						.addBox(3.0F, -8.0F, -6.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 38).addBox(-7.0F, -8.0F, 0.0F, 6.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(42, 38)
						.addBox(-7.0F, -8.0F, 1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(46, 18).addBox(-7.0F, -8.0F, 4.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 47)
						.addBox(-4.0F, -8.0F, 1.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 47).addBox(0.0F, -8.0F, -2.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(10, 47)
						.addBox(-4.0F, -8.0F, 2.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 47).addBox(3.0F, -8.0F, -5.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 47)
						.addBox(-7.0F, -8.0F, 5.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-21.0F, -8.0F, -1.0F, 22.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, 0.0F, -7.0F, 0.0F, 0.7854F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}