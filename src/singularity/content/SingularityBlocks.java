package singularity.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;
import mindustry.world.meta.StatValue;

import static mindustry.type.ItemStack.with;

public class SingularityBlocks {

    public static Block miracle;

    public static void load() {
        miracle = new ItemTurret("miracle") {{
            requirements(Category.turret, with(Items.copper, 100, Items.graphite, 80, Items.titanium, 50));
            size = 3;
            recoil = 4f;
            reloadTime = 60f;
            restitution = 0.05f;
            range = 400f;
            inaccuracy = 10f;
            rotateSpeed = 1.5f;
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
                        despawnEffect = Fx.none;
                        pierce = true;
                        pierceBuilding = true;
                        pierceCap = 5;
                        collidesAir = false;
                    }}
            );

            size = 4;
            health = 600;
            consumes.power(60f);
            consumes.liquid(Liquids.water, 0.5f);
            maxHeat = 0.75f;
            heatColor = Color.red;
            heatCapacity = 1200f;

            stats.add(Stat.heatCapacity, new StatValue() {
                @Override
                public void display(StatUnit unit, StringBuilder builder) {
                    super.display(unit, builder);
                    builder.append(" (").append((int) (maxHeat * 100)).append("%)");
                }
            });
        }};
    }
}
