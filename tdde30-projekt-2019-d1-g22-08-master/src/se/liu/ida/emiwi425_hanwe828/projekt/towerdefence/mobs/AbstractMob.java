package se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.mobs;


import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.Board;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.BlockType;
import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.Direction;

import static se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.Direction.*;


/**
 * This is the abstract class to our mobs. Here we handle the movement of each mob
 * and we also initialize the different attributes that every should mob should have.
 */

public abstract class AbstractMob
{
    private static final double CLOSE_ENOUGH = 0.05;
    private static final double MIDDLE = 0.5;
    protected double x;
    protected double y;
    protected int health;
    protected double speed;
    protected Direction mydirection;

    protected AbstractMob(final double x, final double y, final int health, final double speed, Direction mydirection){
        this.x = x;
        this.y = y;
        this.health = health;
        this.speed = speed;
        this.mydirection = mydirection;
    }


    public double getX() { return x; }


    public double getY() {
        return y;
    }


    public int getHealth() {
        return health;
    }
//Komplettering:
    // Skrev om så att vi använder den nya varianten av withinDistance istället för den nu borttagna middleDistance och
    // ändrade formen på invärden så att det fungerar.
    // Skapade också handle direction som returnar true om den flyttar en mob och false annars.
    public void moveMob(Board b){
        if (b.withinDistance(x,y,Math.floor(x),Math.floor(y),CLOSE_ENOUGH)){
           if (handleDirection(b,mydirection)){
               return;
           }
           else if (handleDirection(b, RIGHT)){
               return;
           }

           else if (handleDirection(b, LEFT)){
               return;
                      }

           else if (handleDirection(b, UP)){
               return;
                      }
           else if (handleDirection(b, DOWN)){
               return;
           }
           else mydirection = NONE;
        } else {
            moveMobDir(mydirection);
        }

    }

    public boolean handleDirection(Board board, Direction direction){
        if (this.validDirection(board, direction)) {
            moveMobDir(direction);
            mydirection = direction;
            return true;
        }
        return false;
    }

    public void moveMobDir(Direction direction) {
        x += (direction.deltaX * speed);
        y += (direction.deltaY * speed);
    }

    public boolean isOppositeDirection(Direction d1, Direction d2){
        return ((d1.deltaX + d2.deltaX == 0) && (d1.deltaY + d2.deltaY == 0));
    }

    // complettering:
    // Tog bort switch satsen och skrev en mer generell variant som förlitar sig på nygjorda deltaX och deltaY
    // Skapade även functionen isOppositeDirection som används så att mobben inte kan gå tillbaka samma väg som den kom ifrån,
    // denna används istället för den gamla (x + speed != oldX || y != oldY))
    public boolean validDirection(Board b, Direction direction){
        BlockType adjacentBlock = b.getBlockType((int)x + direction.deltaX,(int)y + direction.deltaY);
        return (adjacentBlock.enemyCanWalk() && !isOppositeDirection(mydirection, direction));
    }

    public void mobTakeDamage(int attack){ health -= attack; }

    public double getMiddleX(){ return x + MIDDLE; }

    public double getMiddleY(){ return y + MIDDLE; }
}
