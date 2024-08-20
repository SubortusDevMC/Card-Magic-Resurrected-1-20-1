package dev.subortus.cardmagic.item.util;

import dev.subortus.cardmagic.CardMagicMod;
import dev.subortus.cardmagic.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CardMagicMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("cardmagic_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CLUB_CARD.get()))
                    .title(Component.translatable("creativetab.cardmagic_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.CLUB_CARD.get());
                        output.accept(ModItems.LOADED_CLUB_CARD.get());
                        output.accept(ModItems.HOYLES_CLUB_CARD.get());

                        output.accept(ModItems.DIAMOND_CARD.get());
                        output.accept(ModItems.LOADED_DIAMOND_CARD.get());
                        output.accept(ModItems.HOYLES_DIAMOND_CARD.get());

                        output.accept(ModItems.JOKER_CARD.get());
                        output.accept(ModItems.LOADED_JOKER_CARD.get());
                        output.accept(ModItems.HOYLES_JOKER_CARD.get());

                        output.accept(ModItems.SPADE_CARD.get());
                        output.accept(ModItems.LOADED_SPADE_CARD.get());
                        output.accept(ModItems.HOYLES_SPADE_CARD.get());

                        output.accept(ModItems.HEART_CARD.get());
                        output.accept(ModItems.LOADED_HEART_CARD.get());
                        output.accept(ModItems.HOYLES_HEART_CARD.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}