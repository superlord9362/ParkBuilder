package com.grimbo.parkbuilder.entity;

import com.grimbo.parkbuilder.ParkBuilder;
import com.grimbo.parkbuilder.util.Registration;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ParkBuilder.MOD_ID);

    public static final RegistryObject<EntityType<VelociraptorEntity>> VELOCIRAPTOR = ENTITY_TYPES.register("velociraptor",
            () -> EntityType.Builder.create(VelociraptorEntity::new, EntityClassification.MONSTER)
                    .size(1f, 1.5f)
                    .build(new ResourceLocation(ParkBuilder.MOD_ID, "velociraptor").toString()));


    public static void register() {
    }
}

