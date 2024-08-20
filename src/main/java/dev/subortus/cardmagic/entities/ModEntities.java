package dev.subortus.cardmagic.entities;

import dev.subortus.cardmagic.CardMagicMod;
import dev.subortus.cardmagic.entities.projectiles.ClubProjectile;
import dev.subortus.cardmagic.entities.projectiles.DiamondProjectile;
import dev.subortus.cardmagic.entities.projectiles.JokerProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CardMagicMod.MOD_ID);

    public static final RegistryObject<EntityType<ClubProjectile>> CLUB_PROJECTILE =
            ENTITY_TYPES.register("club_projectile", () -> EntityType.Builder.<ClubProjectile>of(ClubProjectile::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("club_projectile"));

    public static final RegistryObject<EntityType<DiamondProjectile>> DIAMOND_PROJECTILE =
            ENTITY_TYPES.register("diamond_projectile", () -> EntityType.Builder.<DiamondProjectile>of(DiamondProjectile::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("diamond_projectile"));

    public static final RegistryObject<EntityType<JokerProjectile>> JOKER_PROJECTILE =
            ENTITY_TYPES.register("joker_projectile", () -> EntityType.Builder.<JokerProjectile>of(JokerProjectile::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("joker_projectile"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
