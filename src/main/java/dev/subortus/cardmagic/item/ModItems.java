package dev.subortus.cardmagic.item;

import dev.subortus.cardmagic.CardMagicMod;
import dev.subortus.cardmagic.item.custom.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> MOD_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CardMagicMod.MOD_ID);

    // CLUB CARDS

    public static final RegistryObject<Item> CLUB_CARD = MOD_ITEMS.register("club_card",
            () -> new Item(new Item.Properties().stacksTo(15)));

    public static final RegistryObject<Item> LOADED_CLUB_CARD = MOD_ITEMS.register("loaded_club_card",
            () -> new ClubCardItem(new Item.Properties().stacksTo(15), "Loaded"));

    public static final RegistryObject<Item> HOYLES_CLUB_CARD = MOD_ITEMS.register("hoyles_club_card",
            () -> new ClubCardItem(new Item.Properties().stacksTo(15), "Hoyle's"));

    //DIAMOND CARDS

    public static final RegistryObject<Item> DIAMOND_CARD = MOD_ITEMS.register("diamond_card",
            () -> new Item(new Item.Properties().stacksTo(15)));

    public static final RegistryObject<Item> LOADED_DIAMOND_CARD = MOD_ITEMS.register("loaded_diamond_card",
            () -> new DiamondCardItem(new Item.Properties().stacksTo(15), "Loaded"));

    public static final RegistryObject<Item> HOYLES_DIAMOND_CARD = MOD_ITEMS.register("hoyles_diamond_card",
            () -> new DiamondCardItem(new Item.Properties().stacksTo(15), "Hoyle's"));

    // JOKER CARDS

    public static final RegistryObject<Item> JOKER_CARD = MOD_ITEMS.register("joker_card",
            () -> new Item(new Item.Properties().stacksTo(15)));

    public static final RegistryObject<Item> LOADED_JOKER_CARD = MOD_ITEMS.register("loaded_joker_card",
            () -> new JokerCardItem(new Item.Properties().stacksTo(15), "Loaded"));

    public static final RegistryObject<Item> HOYLES_JOKER_CARD = MOD_ITEMS.register("hoyles_joker_card",
            () -> new JokerCardItem(new Item.Properties().stacksTo(15), "Hoyle's"));

    // SPADE CARDS

    public static final RegistryObject<Item> SPADE_CARD = MOD_ITEMS.register("spade_card",
            () -> new Item(new Item.Properties().stacksTo(15)));

    public static final RegistryObject<Item> LOADED_SPADE_CARD = MOD_ITEMS.register("loaded_spade_card",
            () -> new SpadeCardItem(new Item.Properties().stacksTo(15), "Loaded"));

    public static final RegistryObject<Item> HOYLES_SPADE_CARD = MOD_ITEMS.register("hoyles_spade_card",
            () -> new SpadeCardItem(new Item.Properties().stacksTo(15), "Hoyle's"));

    // HEART CARDS

    public static final RegistryObject<Item> HEART_CARD = MOD_ITEMS.register("heart_card",
            () -> new Item(new Item.Properties().stacksTo(15)));

    public static final RegistryObject<Item> LOADED_HEART_CARD = MOD_ITEMS.register("loaded_heart_card",
            () -> new HeartCardItem(new Item.Properties().stacksTo(15), "Loaded"));

    public static final RegistryObject<Item> HOYLES_HEART_CARD = MOD_ITEMS.register("hoyles_heart_card",
            () -> new HeartCardItem(new Item.Properties().stacksTo(15), "Hoyle's"));

    public static void register(IEventBus eventBus){
        MOD_ITEMS.register(eventBus);
    }
}
