package CharacterGenerator.NeutralGenerators;

import CharacterGenerator.Interfaces.Randomizer;

import java.util.Random;

/**
 * Created by Greatmelons on 5.2.2015.
 */
public class SeededGenerator implements Randomizer {

    private long seed;

    public SeededGenerator(long seed) {

        this.seed = seed;

    }

    @Override
    public int getRandomNumber(int max) {
        Random seededRandom = new Random(seed);
        return seededRandom.nextInt(max);
    }
}
