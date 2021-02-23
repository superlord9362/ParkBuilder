package com.grimbo.parkbuilder.util;

import com.grimbo.parkbuilder.ParkBuilder;
import net.minecraft.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {

    public static final DeferredRegister<EntityType<?>> ENTITIES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, ParkBuilder.MOD_ID);

    public static void init() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ENTITIES.register(eventBus);
    }

    public static void register() {}

}
