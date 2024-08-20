package dev.subortus.cardmagic.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class HeartCardItem extends Item {

    public String quality;
    public Random random = new Random();

    public HeartCardItem(Properties pProperties, String pQuality) {
        super(pProperties);
        this.quality = pQuality;

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide()){
            byte chance = switch (this.quality) {
                case "Loaded" -> 5;
                case "Hoyle's" -> 8;
                default -> -1;
            };

            if(random.nextInt(10) <= chance){
                pPlayer.heal(8);
            } else {
                pPlayer.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 1, true, true, true));
            }

            pPlayer.getItemInHand(pUsedHand).shrink(1);
        }

        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public Component getName(ItemStack pStack) {
        return Component.literal(this.quality + " " + super.getName(pStack).getString());
    }
}
