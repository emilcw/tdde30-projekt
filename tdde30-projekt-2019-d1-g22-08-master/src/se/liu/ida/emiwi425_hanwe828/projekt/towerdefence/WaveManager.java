package se.liu.ida.emiwi425_hanwe828.projekt.towerdefence;

import se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.mobs.MobType;

import static se.liu.ida.emiwi425_hanwe828.projekt.towerdefence.mobs.MobType.*;
import java.util.ArrayList;
import java.util.List;


/**
 * This class defines the different waves in our game. By calling the method getWave with a certain index we
 * obtain a new wave to our game.
 *
 */

//No need for a constuctor since we do not create an instance of the class.
public final class WaveManager {

    private WaveManager() {}

    public static List<MobType> createMobList(int amount){
       List<MobType> waves = new ArrayList<>();
	for (int i = 0; i < amount; i++) {
		waves.add(BASICMOB);
	}
	return waves;
    }

// A lot of magic numbers but it felt unnecessary to create a seperate variable for every individual wave.
    public static List<MobType> getWave(int waveNr){
        int mobAmount;
	switch(waveNr){
	    case 1:
	        mobAmount = 5;
	        break;
	    case 2:
		mobAmount = 12;
		break;
	    case 3:
		mobAmount = 18;
		break;
	    case 4:
		mobAmount = 25;
		break;
	    case 5:
		mobAmount = 29;
		break;
	    case 6:
		mobAmount = 32;
		break;
	    case 7:
		mobAmount = 38;
		break;
	    case 8:
		mobAmount = 44;
		break;
	    case 9:
		mobAmount = 52;
		break;
	    case 10:
		mobAmount = 58;
		break;

	    default:
	        throw new IllegalArgumentException("Invalid wave:" + waveNr);
	}

	return createMobList(mobAmount);
}

}
