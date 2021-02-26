package se.liu.ida.emiwi425_hanwe828.projekt.towerdefence;

import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.mobs.MobType;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.mobs.AbstractMob;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.mobs.BasicMob;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.towers.AbstractTower;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.towers.BasicTower;

import java.util.ArrayList;
import java.util.List;

/**
 * Our controller class both spawns and removes mobs/towers. The class
 * creates the objects and add them to the corresponding list.
 * The class also updates our mobs, towers and bullets so they can for example detect collisions
 * and detect if something is in range.
 */

public class Controller {
    private static final int MOB_DAMAGE = 1;
    private static final int MOB_REWARD = 10;
    private static final int BULLET_DAMAGE = 1;
    private static final double  COLLISION_DISTANCE = 0.5;


    private int spawnX,spawnY;
    private Board board;                //To create a Board we need a controller, thus we set the board afterwards.


    public void setSpawn(){
           spawnX = board.getSpawnX();
           spawnY = board.getSpawnY();
       }

    private List<AbstractMob> abstractMobs = new ArrayList<>();

// the switch statements are there to make it easier if we want to implement more mobs.
    public void makeMob(double x, double y, MobType type) {
        switch(type){
            case BASICMOB:
                AbstractMob newmob = new BasicMob(x, y);
                abstractMobs.add(newmob);
                break;
            default:
                throw new IllegalArgumentException("Invalid mobtype: " + type);
        }
    }


    private List<AbstractTower> abstractTowers = new ArrayList<>();


    public void makeTower(double x, double y) {
        BasicTower newTower = new BasicTower(x, y);
        abstractTowers.add(newTower);
    }


    public void removeTowerAt(int x, int y){
        for (int i = 0; i < abstractTowers.size(); i++) {
            AbstractTower abstractTower = abstractTowers.get(i);
            if( (x == (int)abstractTower.getX()) && ( y == (int)abstractTower.getY() )){
                removeTower(i);
            }
        }
    }


    public boolean towerAtCoord(int x, int y){
        for (int i = 0; i < abstractTowers.size(); i++) {
            AbstractTower abstractTower = abstractTowers.get(i);
            if ((x == (int) abstractTower.getX()) && (y == (int) abstractTower.getY())) {
                return true;
            }
        }
        return false;
    }


    public void spawnWave(List<MobType> mobTypes){

        if (!mobTypes.isEmpty()){
            MobType mobType = mobTypes.get(0);

            switch(mobType){                    //If we want to add more enemies a switch statement is more useful.

                case BASICMOB:
                    makeMob(spawnX ,spawnY,mobType);
                    mobTypes.remove(0);
                    break;

                default:
                    throw new IllegalArgumentException("No such mob: " + mobType);
            }
        }
    }


    public void updateMobs() {
        for (int i = 0; i < abstractMobs.size(); i++) {
            AbstractMob abstractMob = abstractMobs.get(i);
            abstractMob.moveMob(board);
            if (board.getBlockType((int) abstractMob.getX(), (int) abstractMob.getY()) == BlockType.GOAL) {
                board.takeDamage(MOB_DAMAGE);
                removeMob(i);
            } else if (abstractMob.getHealth() < 1) {
                board.addMoney(MOB_REWARD);
                removeMob(i);
            }
        }
    }


    public void updateTowers() {
        for (int i = 0; i < abstractTowers.size(); i++) {
            AbstractTower abstractTower = abstractTowers.get(i);
            if (abstractTower.noCoolDown()) {
                for (int j = 0; j < abstractMobs.size(); j++) {
                    AbstractMob abstractMob = abstractMobs.get(j);
                    if (abstractTower.inAttackRange(abstractMob)) {
                        abstractTower.attackEnemy(abstractMob);
                        break;
                    }
                }
            }
            for (int s = 0; s < abstractTower.getBullets().size(); s++) {
                Bullet bullet = abstractTower.getBullet(s);
                bullet.moveBullet();
                BlockType block = board.getBlockType((int)bullet.getX(), (int)bullet.getY());
                if(block == BlockType.OUTSIDE){
                    abstractTower.removeBullet(s);}
                for (int j = 0; j < abstractMobs.size(); j++) {
                    AbstractMob abstractMob = abstractMobs.get(j);
                    if(board.withinDistance(bullet.getX(), bullet.getY(), abstractMob.getX(), abstractMob.getY(), COLLISION_DISTANCE)){
                        abstractMob.mobTakeDamage(BULLET_DAMAGE);
                        abstractTower.removeBullet(s);
                        break;


                    }
                }
            }
        }

    }


    public void setBoard(final Board board) { this.board = board; }

    public AbstractMob getMob(int i) {
        return abstractMobs.get(i);
    }

    public int getMobListLen() {
        return abstractMobs.size();
    }

    public void removeMob(int i) {
        abstractMobs.remove(i);
    }

    public AbstractTower getTower(int i) {
          return abstractTowers.get(i);
      }

    public int getTowerListLen() {
      return abstractTowers.size();
    }

    public void removeTower(int i) {
      abstractTowers.remove(i);
    }


}
