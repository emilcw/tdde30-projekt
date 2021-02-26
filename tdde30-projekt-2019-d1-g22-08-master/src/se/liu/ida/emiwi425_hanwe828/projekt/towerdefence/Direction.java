package se.liu.ida.emiwi425_hanwe828.projekt.towerdefence;

/**
 * The different types of directions our BasicMob can move in.
 * By selecting RIGHT, LEFT, UP or DOWN we move in that direction.
 * If no direction is avalible, NONE will be set.
 *
 */

public enum Direction
{

    // read above
    RIGHT(1, 0), LEFT(-1, 0), UP(0, -1), DOWN(0, 1), NONE(0, 0);

    public final int deltaX;
    public final int deltaY;

    Direction(final int deltaX, final int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }
    }
