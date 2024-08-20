package dev.subortus.cardmagic.item.custom;

import dev.subortus.cardmagic.entities.projectiles.DiamondProjectile;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class DiamondCardItem extends Item {

    public String quality;

    public DiamondCardItem(Properties pProperties, String pQuality) {
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

            if(new Random().nextInt(10) <= chance){
                DiamondProjectile projectile = new DiamondProjectile(pLevel, pPlayer);
                projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 4.0F, 1.0F);

                pLevel.addFreshEntity(projectile);
            } else {
                pLevel.explode(null,pPlayer.getX(),pPlayer.getY()+1,pPlayer.getZ(),2f, Level.ExplosionInteraction.NONE);
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
