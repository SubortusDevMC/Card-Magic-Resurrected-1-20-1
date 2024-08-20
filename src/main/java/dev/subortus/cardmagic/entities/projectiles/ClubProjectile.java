package dev.subortus.cardmagic.entities.projectiles;

import dev.subortus.cardmagic.entities.ModEntities;
import dev.subortus.cardmagic.event.SpawnHandler;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class ClubProjectile extends ThrowableItemProjectile {
    public ClubProjectile(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ClubProjectile(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.CLUB_PROJECTILE.get(), livingEntity, pLevel);
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return Blocks.AIR.asItem();
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if(!this.level().isClientSide()){
            this.level().broadcastEntityEvent(this, ((byte) 3));
            SpawnHandler.spawnRandom(level(), this.position());
        }
        this.discard();
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

        this.level().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), x, y, z);
    }
}
