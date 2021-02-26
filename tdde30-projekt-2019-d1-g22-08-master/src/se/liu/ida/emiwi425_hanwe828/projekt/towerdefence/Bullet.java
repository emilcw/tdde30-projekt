package se.liu.ida.emiwi425_hanwe828.projekt.towerdefence;

/**
 * This is our bullet class, it is created by towers and has a move method.
 */

public class Bullet {

	private double speed;
	private double x,y;
	private double angle;

    public Bullet(final double speed, final double x, final double y, final double angle) {
	this.speed = speed;
	this.x = x;
	this.y = y;
	this.angle = angle;
    }

    public void moveBullet(){
        double nextY = Math.sin(angle) * speed;
	double nextX = Math.cos(angle) * speed;
	x += nextX;
	y += nextY;
    }

    public double getX() {
	return x;
    }

    public double getY() {
	return y;
    }

}
