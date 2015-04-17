package neutralGenerators;

import interfaces.Randomizer;

import java.util.Random;

/**
 * Forces the Random class to use a specific seed
 * Created by Greatmelons on 5.2.2015.
 */
public class SeededGenerator implements Randomizer {

    private long seed;
    
    /**
     * Constructor for SeededGenerator
     * @param seed 
     */
    public SeededGenerator(long seed) {

        this.seed = seed;

    }
    /**
     * Forces Random class to use a seed determined by the user
     * @param max
     * @return int randomNumber
     */
    @Override
    public int getRandomNumber(int max) {
        Random seededRandom = new Random(seed);
        return seededRandom.nextInt(max);
    }
}
