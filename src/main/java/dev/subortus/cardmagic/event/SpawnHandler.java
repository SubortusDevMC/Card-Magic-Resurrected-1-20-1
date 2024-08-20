package dev.subortus.cardmagic.event;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class SpawnHandler {
    protected static Random random = new Random();

    public static void spawnRandom(Level pLevel, Vec3 pos){
        switch (random.nextInt(4)){
            case 3:{
                for(int i = 0; i <= 1; i++){
                    Zombie zombie = new Zombie(pLevel);
                    zombie.setPos(pos.x + random.nextInt(-1,1), pos.y, pos.z + random.nextInt(-1,1));
                    pLevel.addFreshEntity(zombie);
                }
                break;
            }
            case 2:{
                for(int i = 0; i <= 1; i++){
                    Spider spider = new Spider(EntityType.SPIDER,pLevel);
                    spider.setPos(pos.x + random.nextInt(-1,1), pos.y, pos.z + random.nextInt(-1,1));
                    pLevel.addFreshEntity(spider);
                }
                break;
            }
            case 1:{
                Skeleton skeleton = new Skeleton(EntityType.SKELETON,pLevel);
                skeleton.setPos(pos.x + random.nextInt(-1,1), pos.y, pos.z + random.nextInt(-1,1));
                pLevel.addFreshEntity(skeleton);
                break;
            }
            case 0:{
                CaveSpider caveSpider = new CaveSpider(EntityType.CAVE_SPIDER,pLevel);
                caveSpider.setPos(pos.x + random.nextInt(-1,1), pos.y, pos.z + random.nextInt(-1,1));
                pLevel.addFreshEntity(caveSpider);
                break;
            }
        }
    }
}
