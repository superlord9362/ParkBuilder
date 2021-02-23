package com.grimbo.parkbuilder.entity.render;

import com.grimbo.parkbuilder.entity.VelociraptorEntity;
import com.grimbo.parkbuilder.entity.model.VelociraptorModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class VelociraptorRender extends GeoEntityRenderer<VelociraptorEntity>
{
    public VelociraptorRender (EntityRendererManager renderManager)
    {
        super(renderManager, new VelociraptorModel());
        this.shadowSize = 0.7F;
    }

    @Override
    public RenderType getRenderType (VelociraptorEntity animatable, float partialTicks, MatrixStack stack, @Nullable IRenderTypeBuffer renderTypeBuffer, @Nullable IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation)
    {
        return RenderType.getEntityTranslucent(getTextureLocation(animatable));
    }
}