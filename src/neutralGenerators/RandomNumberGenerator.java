package neutralGenerators;

import interfaces.Randomizer;

import java.util.Random;

/**
 * Created by Greatmelons on 5.2.2015.
 */
public class RandomNumberGenerator implements Randomizer {

    public int getRandomNumber(int max) {
        Random randomizer = new Random();
        return randomizer.nextInt(max);
    }

}
