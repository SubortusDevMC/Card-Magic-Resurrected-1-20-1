package dev.subortus.cardmagic;

import com.mojang.logging.LogUtils;
import dev.subortus.cardmagic.entities.ModEntities;
import dev.subortus.cardmagic.item.ModItems;
import dev.subortus.cardmagic.item.util.ModCreativeModeTabs;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CardMagicMod.MOD_ID)
public class CardMagicMod
{

    public static final String MOD_ID = "cardmagic";

    private static final Logger LOGGER = LogUtils.getLogger();

    public CardMagicMod(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModEntities.register(modEventBus);

        ModItems.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntities.CLUB_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.DIAMOND_PROJECTILE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.JOKER_PROJECTILE.get(), ThrownItemRenderer::new);

        }
    }
}
