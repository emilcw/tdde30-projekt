package se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.towers;

import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.Bullet;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.mobs.AbstractMob;

import java.util.ArrayList;
import java.util.List;


/**
 * This is our abstract tower class which all towers extend. Here we define different attributes
 * all towers should have. We have also define certain methods that all towers could use such as
 * detecting mobs, shooting enemies, counting down their cooldown and manipulating there bullets.
 *
 */

public abstract class AbstractTower implements TowerInterface {

    protected double x;
    protected double y;
    protected int range;
    protected int attackCoolDown;
    protected int coolDownLeft;
    private static final double MIDDLE = 0.5;
    protected List<Bullet> bullets;


    protected AbstractTower(final double x, final double y, int attackCoolDown, int range) {
        this.x = x;
        this.y = y;
        this.range = range;
        this.attackCoolDown = attackCoolDown;
        bullets = new ArrayList<>();

    }

    public boolean noCoolDown() {
        if (coolDownLeft < 1) {
            return true;
        } else {
            coolDownLeft--;
            return false;
        }
    }

    public boolean inAttackRange(AbstractMob abstractMob) {
        //Pythagoras Theorem
        double dist = Math.sqrt((abstractMob.getX() - x) * (abstractMob.getX() - x) + (abstractMob.getY() - y) * (abstractMob.getY() - y));
        return (dist < range);
    }

    public double getTargetAngle(AbstractMob abstractMob) {
        double myX = this.getMiddleX();
        double myY = this.getMiddleY();
        double targetX = abstractMob.getMiddleX();
        double targetY = abstractMob.getMiddleY();
        double angle = Math.atan2(targetY - myY, targetX - myX);
        return angle;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }


    public Bullet getBullet(int i) {
        return bullets.get(i);
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void removeBullet(int i) {
        bullets.remove(i);
    }


    public int getRange() {
        return range;
    }

    public double getMiddleX() {
        return x + MIDDLE;
    }

    public double getMiddleY() {
        return y + MIDDLE;
    }

}