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
                Items.blastCompound, new MissileBulletType(3.7f, 10) {{
                    reloadMultiplier = 0.3f;
                    width = 16f;
                    height = 16f;
                    shrinkY = 0f;
                    lightningDamage = 10;
                    lightning = 2;
                    lightningLength = 10;
                    lightningColor = Color.red;
                    splashDamageRadius = 30f;
                    splashDamage = 30f * 1.5f;
                    ammoMultiplier = 5f;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;

                    status = StatusEffects.blasted;
                    statusDuration = 60f;
                }}

            );

            size = 2;
            range = 190f;
            reload = 31f;
            consumeAmmoOnce = false;
            ammoEjectBack = 3f;
            recoil = 3f;
            shake = 1f;
            shoot.shots = 4;
            shoot.shotDelay = 3f;

            ammoUseEffect = Fx.casing2;
            scaledHealth = 240;
            shootSound = Sounds.shootBig;

            limitRange();
        }};
        
    }
}
