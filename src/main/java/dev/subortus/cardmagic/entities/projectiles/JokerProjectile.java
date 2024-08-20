package dev.subortus.cardmagic.entities.projectiles;

import dev.subortus.cardmagic.entities.ModEntities;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;

public class JokerProjectile extends ThrowableItemProjectile {

    public static LivingEntity thrower;

    public JokerProjectile(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public JokerProjectile(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.JOKER_PROJECTILE.get(), livingEntity, pLevel);
        thrower = livingEntity;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {

        Entity entity = pResult.getEntity();
        if(!this.level().isClientSide()){
            entity.setPos(thrower.position().add(0, 1,0));
            thrower.teleportTo(this.getX(),this.getY(), this.getZ());
            this.level().playSound(null, this.xo, this.yo, this.zo, SoundEvents.ENDERMAN_TELEPORT, this.getSoundSource(), 1.0F, 1.0F);
            this.level().playSound(null, entity.xo, entity.yo, entity.zo, SoundEvents.ENDERMAN_TELEPORT, entity.getSoundSource(), 1.0F, 1.0F);

        }

        this.discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        this.discard();
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return Blocks.AIR.asItem();
    }

    @Override
    public void tick() {
        super.tick();
        double x;
        if (random.nextBoolean()) {
            x = Math.random() / 20.0;
        } else {
            x = -Math.random() / 20.0;
        }

        double y;
        if (random.nextBoolean()) {
            y = Math.random() / 20.0;
        } else {
            y = -Math.random() / 20.0;
        }

        double z;
        if (random.nextBoolean()) {
            z = Math.random() / 20.0;
        } else {
            z = -Math.random() / 20.0;
        }

        this.level().addParticle(ParticleTypes.ENCHANTED_HIT, this.getX(), this.getY(), this.getZ(), x, y, z);
    }
}
