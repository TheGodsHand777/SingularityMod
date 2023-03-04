package singularity.content;

import arc.graphics.Color;
import mindustry.content.*;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;
import mindustry.world.meta.StatValue;

public class SingularityBlocks {

    public static Block miracle;

    public static void load() {
        miracle = new ItemTurret("miracle") {{
            requirements(Category.turret, Items.copper, 100, Items.graphite, 80, Items.titanium, 50);
            size = 3;
            recoil = 4f;
            reloadTime = 60f;
            restitution = 0.05f;
            range = 400f;
            inaccuracy = 10f;
            rotateSpeed = 10f;
            shake = 4f;
            shootSound = Sounds.laserblast;
            shots = 1;
            shotDelay = 0f;
            continuous = true;

            ammo(
                    Items.pyratite, new LaserBulletType(30){{
                        length = 400f;
                        width = 12f;
                        damage = 45f;
                        lifetime = 24f;
                        hitEffect = Fx.hitLancer;
                        colors = new Color[]{Color.valueOf("#f5c77f"), Color.valueOf("#e7635a"), Color.white};
                        despawnEffect = Fx.noneHit;
                        pierce = true;
                        pierceBuilding = true;
                        pierceCap = 3;
                        collidesAir = false;
                    }}
            );

            size = 4;
            health = 600;
            consumes.power(60f);
            consumes.liquid(Liquids.water, 0.1f);
            maxHeat = 0.6f;
            heatColor = Pal.lightFlame;
            heatCapacity = 960f;

            stats.add(Stat.heatCapacity, new StatValue() {
                @Override
                public void display(StatUnit unit, StringBuilder builder) {
                    builder.append((int) (maxHeat * 100)).append("%");
                }
            });
        }};
    }
}
