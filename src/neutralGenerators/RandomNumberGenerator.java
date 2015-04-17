package neutralGenerators;

import interfaces.Randomizer;

import java.util.Random;

/**
 * Basic random number generator
 * Created by Greatmelons on 5.2.2015.
 */
public class RandomNumberGenerator implements Randomizer {
    
    /**
     * Generates a random number
     * @param max
     * @return int randomNumber
     */
    @Override
    public int getRandomNumber(int max) {
        Random randomizer = new Random();
        return randomizer.nextInt(max);
    }

}
