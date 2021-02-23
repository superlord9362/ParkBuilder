package com.grimbo.parkbuilder.entity;

import com.grimbo.parkbuilder.ParkBuilder;
import com.grimbo.parkbuilder.entity.render.VelociraptorRender;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid= ParkBuilder.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void onClientSetup (FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.VELOCIRAPTOR.get(), VelociraptorRender::new);
    }

}