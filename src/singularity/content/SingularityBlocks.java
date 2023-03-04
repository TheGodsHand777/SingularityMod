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
        miracle = new PowerTurret("miracle") {{
            requirements(Category.turret, with(Items.copper, 100, Items.graphite, 80, Items.titanium, 50));
            coolant(Liquids.water, 0.2f);
            size = 2;
            range = 190f;
            reload = 31f;
            recoil = 3f;
            powerUse = 6.0f;
            rotateSpeed = 10.0f;
            shootEffect = Fx.none;
            shootType = new LaserBulletType(30f) {{
                length = 200f;
                width = 8f;
                lifetime = 60f;
                colors = new Color[]{Color.valueOf("#FFD5FF"), Color.valueOf("#FF74FF")};
                shootEffect = Fx.hitLaser;
                hitEffect = Fx.hitLaser;
                despawnEffect = Fx.none;
                pierce = true;
                pierceCap = 5;
                pierceBuilding = true;
            }};
            shootSound = Sounds.laser;
            limitRange();
        }};
    }
}
