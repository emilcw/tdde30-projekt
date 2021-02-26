package se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.towers;

import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.Bullet;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.mobs.AbstractMob;


/**
 * This is our BasicTower. It has no special characteristics.
 * By using the method attackEnemy they will spawn in new bullets.
 */

public class BasicTower extends AbstractTower
{

    private static final int BASICCOST = 100;
    private static final int BASIC_RANGE = 5;
    private static final int BASIC_COOLDOWN = 200;
    private static final double BASIC_BULLETSPEED = 0.07;


    public BasicTower(final double x, final double y) {
        super(x,y, BASIC_COOLDOWN, BASIC_RANGE);
    }

    @Override public void attackEnemy(AbstractMob abstractmob){
        double targetAngle = getTargetAngle(abstractmob);
        coolDownLeft = attackCoolDown;
        bullets.add(new Bullet(BASIC_BULLETSPEED, x, y, targetAngle));
    }



    public static int getBASICCOST(){
        return BASICCOST;
    }

}
