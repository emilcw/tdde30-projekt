package se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.maps;

import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.BlockType;

import static se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.BlockType.*;

/**
 * This class mainly creates our maps. By initializing arrays with enum-constants
 * we obtain different maps. This is one with the method mapSelector.
 */

public class TowerDefenceMapMaker
{


    public BlockType[][] mapSelector(int x){

        BlockType[][] newMap;

        switch(x) {

	    case 1:
	        //create TowerDefenceMap 1
		newMap = new BlockType[][] {
			{OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,ROAD,ROAD,ROAD,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GOAL,ROAD,ROAD,ROAD,ROAD,GRASS,GRASS,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,SPAWN,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE}


		};
		break;


	    case 2:
	    //create TowerDefenceMap 2
		newMap = new BlockType[][] {
			{OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,STONE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GOAL,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,ROAD,ROAD,ROAD,ROAD,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,ROAD,ROAD,SPAWN,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,ROAD,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,WATER,GRASS,GRASS,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,ROAD,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,WATER,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,OUTSIDE},
			{OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE,OUTSIDE}

			};
		break;


	    default:
	        throw new IllegalArgumentException("Invalid map: " + x);


		}
	    return newMap;
	}
    }




