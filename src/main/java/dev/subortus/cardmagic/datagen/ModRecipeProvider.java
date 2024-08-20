package dev.subortus.cardmagic.datagen;

import dev.subortus.cardmagic.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        // CLUBS

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CLUB_CARD.get(), 5)
                .pattern("   ")
                .pattern("SPS")
                .pattern("   ")
                .define('S', Items.INK_SAC)
                .define('P', Items.PAPER)
                .unlockedBy(getHasName(Items.INK_SAC), has(Items.INK_SAC))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LOADED_CLUB_CARD.get(), 5)
                .requires(Items.BONE_MEAL)
                .requires(ModItems.CLUB_CARD.get(),5)
                .unlockedBy(getHasName(ModItems.CLUB_CARD.get()), has(ModItems.CLUB_CARD.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HOYLES_CLUB_CARD.get(), 5)
                .requires(Items.ENDER_PEARL)
                .requires(ModItems.CLUB_CARD.get(),5)
                .unlockedBy(getHasName(ModItems.CLUB_CARD.get()), has(ModItems.CLUB_CARD.get()))
                .save(pWriter);

        // DIAMONDS

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_CARD.get(), 5)
                .pattern(" R ")
                .pattern(" P ")
                .pattern(" R ")
                .define('R', Items.RED_DYE)
                .define('P', Items.PAPER)
                .unlockedBy(getHasName(Items.RED_DYE), has(Items.RED_DYE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LOADED_DIAMOND_CARD.get(), 5)
                .requires(Items.BONE_MEAL)
                .requires(ModItems.DIAMOND_CARD.get(),5)
                .unlockedBy(getHasName(ModItems.DIAMOND_CARD.get()), has(ModItems.DIAMOND_CARD.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HOYLES_DIAMOND_CARD.get(), 5)
                .requires(Items.ENDER_PEARL)
                .requires(ModItems.DIAMOND_CARD.get(),5)
                .unlockedBy(getHasName(ModItems.DIAMOND_CARD.get()), has(ModItems.DIAMOND_CARD.get()))
                .save(pWriter);

        // JOKERS

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.JOKER_CARD.get(), 5)
                .pattern(" S ")
                .pattern(" P ")
                .pattern(" R ")
                .define('R', Items.RED_DYE)
                .define('S', Items.INK_SAC)
                .define('P', Items.PAPER)
                .unlockedBy(getHasName(Items.RED_DYE), has(Items.RED_DYE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LOADED_JOKER_CARD.get(), 5)
                .requires(Items.BONE_MEAL)
                .requires(ModItems.JOKER_CARD.get(),5)
                .unlockedBy(getHasName(ModItems.JOKER_CARD.get()), has(ModItems.JOKER_CARD.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HOYLES_JOKER_CARD.get(), 5)
                .requires(Items.ENDER_PEARL)
                .requires(ModItems.JOKER_CARD.get(),5)
                .unlockedBy(getHasName(ModItems.JOKER_CARD.get()), has(ModItems.JOKER_CARD.get()))
                .save(pWriter);

        // SPADES

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SPADE_CARD.get(), 5)
                .pattern(" S ")
                .pattern(" P ")
                .pattern(" S ")
                .define('S', Items.INK_SAC)
                .define('P', Items.PAPER)
                .unlockedBy(getHasName(Items.INK_SAC), has(Items.INK_SAC))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LOADED_SPADE_CARD.get(), 5)
                .requires(Items.BONE_MEAL)
                .requires(ModItems.SPADE_CARD.get(),5)
                .unlockedBy(getHasName(ModItems.SPADE_CARD.get()), has(ModItems.SPADE_CARD.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HOYLES_SPADE_CARD.get(), 5)
                .requires(Items.ENDER_PEARL)
                .requires(ModItems.SPADE_CARD.get(),5)
                .unlockedBy(getHasName(ModItems.SPADE_CARD.get()), has(ModItems.SPADE_CARD.get()))
                .save(pWriter);

        // HEARTS

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HEART_CARD.get(), 5)
                .pattern("   ")
                .pattern("RPR")
                .pattern("   ")
                .define('R', Items.RED_DYE)
                .define('P', Items.PAPER)
                .unlockedBy(getHasName(Items.RED_DYE), has(Items.RED_DYE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LOADED_HEART_CARD.get(), 5)
                .requires(Items.BONE_MEAL)
                .requires(ModItems.HEART_CARD.get(),5)
                .unlockedBy(getHasName(ModItems.HEART_CARD.get()), has(ModItems.HEART_CARD.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HOYLES_HEART_CARD.get(), 5)
                .requires(Items.ENDER_PEARL)
                .requires(ModItems.HEART_CARD.get(),5)
                .unlockedBy(getHasName(ModItems.HEART_CARD.get()), has(ModItems.HEART_CARD.get()))
                .save(pWriter);

    }

}
