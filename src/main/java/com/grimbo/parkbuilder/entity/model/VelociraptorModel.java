package com.grimbo.parkbuilder.entity.model;

import com.grimbo.parkbuilder.ParkBuilder;
import com.grimbo.parkbuilder.entity.VelociraptorEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VelociraptorModel extends AnimatedGeoModel<VelociraptorEntity> {

    @Override
    public ResourceLocation getModelLocation(VelociraptorEntity object) {
        return new ResourceLocation(ParkBuilder.MOD_ID, "geo/velociraptor.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(VelociraptorEntity object) {
        return new ResourceLocation(ParkBuilder.MOD_ID, "textures/entity/velociraptor.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(VelociraptorEntity object) {
        return new ResourceLocation(ParkBuilder.MOD_ID, "animations/velociraptor_walk.json");
    }
}