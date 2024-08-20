package dev.subortus.cardmagic.item.custom;

import dev.subortus.cardmagic.entities.projectiles.ClubProjectile;
import dev.subortus.cardmagic.event.SpawnHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class ClubCardItem extends Item {

    public String quality;

    public ClubCardItem(Properties pProperties, String pQuality) {
        super(pProperties);
        this.quality = pQuality;

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide()){

            // Check quality of item and generate probability of item effect working.
            byte chance = switch (this.quality) {
                case "Loaded" -> 5;
                case "Hoyle's" -> 8;
                default -> -1;
            };


            // If from 0 to 9 it is less than or equal to the probability of the item firing, fire the projectile.
            if(new Random().nextInt(10) <= chance){
                ClubProjectile projectile = new ClubProjectile(pLevel, pPlayer);
                projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 2.0F, 1.0F);

                pLevel.addFreshEntity(projectile);
            } else {
                SpawnHandler.spawnRandom(pLevel,pPlayer.position().add(0, 0.5, 0));
            }

            // If the user is in survival or adventure, decrease the item stack by one.
            pPlayer.getItemInHand(pUsedHand).shrink(1);
        }

        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public Component getName(ItemStack pStack) {
        // This to save me literally three seconds.
        return Component.literal(this.quality + " " + super.getName(pStack).getString());
    }
}
