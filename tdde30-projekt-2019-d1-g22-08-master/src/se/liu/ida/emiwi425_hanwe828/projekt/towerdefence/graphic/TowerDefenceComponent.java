package se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.graphic;

import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.BlockType;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.Board;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.BoardListener;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.Bullet;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.Controller;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.mobs.AbstractMob;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.towers.AbstractTower;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;
import static java.awt.Color.*;
import static se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.BlockType.*;


/**
 * This class draws our board and relevenat gameobjects such as towers, mobs and bullets.
 *
 */


public class TowerDefenceComponent extends JComponent implements BoardListener
{


    private final static int SQUARE_SIDE = 40;
    private final static int SQUARE_MULTIPLIER = 41;
    private final static int MENU_CONSTANT = 6;
    private final static int BORDER_CONSTANT = 20;
    private final static int BULLET_RADIUS = 10;

    private Board brd;
    private Controller cont;

    public TowerDefenceComponent(final Board brd, final Controller cont) {
	this.brd = brd;
	this.cont = cont;
	//Unnecessary to turn them into constants since we might want to change them
	//and then we have to change every single constant.
	colorTable.put(GRASS, new Color(112, 255, 41));
	colorTable.put(STONE,new Color(125, 124, 121));
	colorTable.put(WATER,new Color(37, 181, 255));
	colorTable.put(ROAD,new Color(245, 197, 87));
	colorTable.put(SPAWN,new Color(255, 13, 227));
	colorTable.put(GOAL,new Color(0, 30, 175));
	colorTable.put(OUTSIDE,new Color(0, 0, 0));
    }


    @Override
    public Dimension getPreferredSize(){
	super.getPreferredSize();
	int width = SQUARE_SIDE * (brd.getWidth() + MENU_CONSTANT);
	int height = BORDER_CONSTANT + SQUARE_SIDE * (brd.getHeight());
	return new Dimension(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics g2d = (Graphics2D) g;	//This is how we were told to do it.

	for (int rows = 0; rows < brd.getWidth(); rows++) {
	    for (int columns = 0; columns < brd.getHeight(); columns++) {

	        //Draw Board
		BlockType pos = brd.getBlockType(rows, columns);
		g2d.setColor(getColor(pos));
		g2d.drawRect(rows * SQUARE_MULTIPLIER, columns * SQUARE_MULTIPLIER, SQUARE_SIDE, SQUARE_SIDE);
		g2d.fillRect(rows * SQUARE_MULTIPLIER, columns * SQUARE_MULTIPLIER, SQUARE_SIDE - 1, SQUARE_SIDE - 1);
	    }
	}
	//Draw mobs
	for (int i = 0; i < cont.getMobListLen(); i++) {
	    AbstractMob basicMob = cont.getMob(i);
	    g2d.setColor(RED);
	    drawSquareCreature(basicMob.getX(), basicMob.getY(), g2d);

	}
	//Draw towers
	for (int i = 0; i < cont.getTowerListLen(); i++) {
	    AbstractTower tower = cont.getTower(i);
	    g2d.setColor(YELLOW);
	    drawSquareCreature(tower.getX(), tower.getY(), g2d);
	    double doubleX = tower.getX() * SQUARE_MULTIPLIER;
	    double doubleY = tower.getY() * SQUARE_MULTIPLIER;
	    int intX = (int) doubleX;
	    int intY = (int) doubleY;

	    //Draw Circle around tower
	    g2d.setColor(BLACK);
	    g2d.drawOval(intX + SQUARE_SIDE/2 - tower.getRange() * SQUARE_MULTIPLIER, intY + SQUARE_SIDE/2 - tower.getRange() * SQUARE_MULTIPLIER,
			 tower.getRange() * 2 * SQUARE_MULTIPLIER, tower.getRange() * 2 * SQUARE_MULTIPLIER);

	    //Draw Bullet
	    for (int s = 0; s < tower.getBullets().size(); s++) {
		Bullet bullet = tower.getBullet(s);
		double doubleXb = bullet.getX() * SQUARE_MULTIPLIER;
		double doubleYb = bullet.getY() * SQUARE_MULTIPLIER;
		int intXb = (int) doubleXb;
		int intYb = (int) doubleYb;
		g2d.setColor(BLUE);
		g2d.drawOval(intXb + SQUARE_SIDE/2 , intYb + SQUARE_SIDE/2 ,BULLET_RADIUS * 2 , BULLET_RADIUS * 2);
		g2d.fillOval(intXb + SQUARE_SIDE/2 , intYb + SQUARE_SIDE/2 ,BULLET_RADIUS * 2 , BULLET_RADIUS * 2);
	    }
	}
    }

    protected void drawSquareCreature(double x, double y, Graphics g2d){
		    double doubleX = x * SQUARE_MULTIPLIER;
		    double doubleY = y * SQUARE_MULTIPLIER;
		    int intX = (int) doubleX;
		    int intY = (int) doubleY;
		    //g2d.setColor(RED);
		    g2d.drawRect(intX, intY, SQUARE_SIDE, SQUARE_SIDE);
		    g2d.fillRect(intX, intY, SQUARE_SIDE - 1, SQUARE_SIDE - 1);

    }

    /**
     * In this EnumMap we store our different colors to paint our board.
     *
     */
    private static EnumMap<BlockType,Color> colorTable = new EnumMap<>(BlockType.class);



    public Color getColor(BlockType s) {
	return colorTable.get(s);

    }
    @Override public void boardChanged() {
	repaint();
    }

}
