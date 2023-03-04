package singularity.content;

import arc.graphics.Color;
import mindustry.entities.bullet.*;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.type.*;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.Fx;
import mindustry.graphics.Layer;
import mindustry.content.StatusEffects;

import mindustry.gen.Sounds;

import static mindustry.type.ItemStack.with;


public class SingularityBlocks {

    public static Block miracle;

    public static void load() {
        miracle = new ItemTurret("miracle"){{
            requirements(Category.turret, with(Items.copper, 100, Items.graphite, 80, Items.titanium, 50));
            ammo(
                    Liquids.water, new LaserBulletType(12f){{
                        length = 100f;
                        width = 20f;
                        lifetime = 120f;
                        colors = new Color[]{Color.valueOf("#FFD5FF"), Color.valueOf("#FF74FF")};
                        shootEffect = Fx.hitLaser;
                        hitEffect = Fx.hitLaser;
                        despawnEffect = Fx.none;
                        pierce = true;
                        pierceCap = 5;
                        pierceBuilding = true;
                    }}
            );

            size = 2;
            range = 190f;
            reload = 31f;
            consumeAmmoOnce = false;
            ammoEjectBack = 3f;
            recoil = 3f;
            shake = 1f;
            shoot.shots = 1;
            shoot.shotDelay = 0.03f;

            ammoUseEffect = Fx.none;
            scaledHealth = 240;
            shootSound = Sounds.laserblast;

            limitRange();
        }};
    }
}
