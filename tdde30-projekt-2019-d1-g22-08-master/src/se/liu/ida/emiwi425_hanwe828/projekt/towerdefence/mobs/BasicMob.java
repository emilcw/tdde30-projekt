package se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.mobs;

import static se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.Direction.*;


/**
 * This is our BasicMob. This mob has no special characteristics.
 */

public class BasicMob extends AbstractMob
{
    private static final int HEALTH = 8;
    private static final double SPEED = 0.008;

    public BasicMob(final double x, final double y) {
        super(x, y,HEALTH, SPEED, NONE);

    }

}
