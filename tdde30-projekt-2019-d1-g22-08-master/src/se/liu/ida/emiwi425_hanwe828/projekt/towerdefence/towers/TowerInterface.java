package se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.towers;

import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.mobs.AbstractMob;

/**
 * Here we define methods that all towers should implement. Currently only the attack command is here.
 *
 */

public interface TowerInterface {

    public void attackEnemy(AbstractMob abstractmob);

}
