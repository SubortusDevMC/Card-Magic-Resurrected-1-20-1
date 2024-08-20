package dev.subortus.cardmagic.item.custom;

import dev.subortus.cardmagic.entities.projectiles.JokerProjectile;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.util.Random;

public class JokerCardItem extends Item {

    public String quality;

    public JokerCardItem(Properties pProperties, String pQuality) {
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
                if (pPlayer.isPassenger()) {
                    pPlayer.stopRiding();
                }
                JokerProjectile projectile = new JokerProjectile(pLevel, pPlayer);
                projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 3.0F, 1.0F);

                pLevel.addFreshEntity(projectile);
            } else {

                double x;
                double z;
                int y;

                do {
                    x = pPlayer.getRandomX(50);
                    z = pPlayer.getRandomZ(50);
                    y = (int) (pPlayer.getY() + new Random().nextInt(-3, 5));

                } while (pLevel.getBlockState(new BlockPos(((int) x), y, (int) z).above(1)).getBlock() != Blocks.AIR
                        ||
                        pLevel.getBlockState(new BlockPos(((int) x), y, (int) z).below(1)).getBlock() == Blocks.AIR);

               pPlayer.teleportTo(x,y,z);
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
