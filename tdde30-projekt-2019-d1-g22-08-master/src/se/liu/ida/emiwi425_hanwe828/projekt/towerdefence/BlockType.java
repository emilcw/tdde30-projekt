package se.liu.ida.emiwi425_hanwe828.projekt.towerdefence;


/**
 * The different types of blocks that our MapObject might consist of.
 *OUTSIDE is the border that surronds the playable area.
 * GRASS and STONE are the only blocks where we can place towers.
 * ROAD is the block our mobs will follow.
 * SPAWN is the block where our mobs will spawn and GOAL
 * is the block where they will despawn and where we will take damage.
 */

public enum BlockType {
//the above description is enough.

    GRASS,STONE,WATER,ROAD,OUTSIDE, SPAWN, GOAL;


    public boolean canPlaceTower(){
        switch(this) {
            case GRASS: return true;
            case STONE: return true;
            default : return false;

        }
    }

    public boolean enemyCanWalk(){
        switch(this){
            case SPAWN : return true;
            case ROAD : return true;
            case GOAL : return true;
            default : return false;
        }
    }
}
