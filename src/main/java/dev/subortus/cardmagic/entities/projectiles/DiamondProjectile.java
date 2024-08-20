package dev.subortus.cardmagic.entities.projectiles;

import dev.subortus.cardmagic.entities.ModEntities;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class DiamondProjectile extends ThrowableItemProjectile {

    public static LivingEntity thrower;

    public DiamondProjectile(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public DiamondProjectile(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.DIAMOND_PROJECTILE.get(), livingEntity, pLevel);
        thrower = livingEntity;
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);

        this.level().explode(thrower, this.getX(), this.getY(), this.getZ(), 5, Level.ExplosionInteraction.NONE);
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

        this.level().addParticle(ParticleTypes.LAVA, this.getX(), this.getY(), this.getZ(), x, y, z);
    }
}
