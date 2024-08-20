package dev.subortus.cardmagic.datagen;

import dev.subortus.cardmagic.CardMagicMod;
import dev.subortus.cardmagic.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CardMagicMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.CLUB_CARD,"generated");
        simpleItem(ModItems.LOADED_CLUB_CARD,"generated");
        simpleItem(ModItems.HOYLES_CLUB_CARD,"generated");

        simpleItem(ModItems.DIAMOND_CARD,"generated");
        simpleItem(ModItems.LOADED_DIAMOND_CARD,"generated");
        simpleItem(ModItems.HOYLES_DIAMOND_CARD,"generated");

        simpleItem(ModItems.JOKER_CARD,"generated");
        simpleItem(ModItems.LOADED_JOKER_CARD,"generated");
        simpleItem(ModItems.HOYLES_JOKER_CARD,"generated");

        simpleItem(ModItems.SPADE_CARD,"generated");
        simpleItem(ModItems.LOADED_SPADE_CARD,"generated");
        simpleItem(ModItems.HOYLES_SPADE_CARD,"generated");

        simpleItem(ModItems.HEART_CARD,"generated");
        simpleItem(ModItems.LOADED_HEART_CARD,"generated");
        simpleItem(ModItems.HOYLES_HEART_CARD,"generated");

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item, String type){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/"+type)).texture("layer0",
                new ResourceLocation(CardMagicMod.MOD_ID, "item/" + item.getId().getPath()));
    }

}
