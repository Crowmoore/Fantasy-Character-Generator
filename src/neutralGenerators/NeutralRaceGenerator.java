/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutralGenerators;

import enums.Race;
import interfaces.RaceGenerator;
import interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class NeutralRaceGenerator implements RaceGenerator{
    
    List<Race> races;
    Randomizer randomizer;
    
    public NeutralRaceGenerator(Randomizer randomizer, List<Race> races) {
        this.randomizer = randomizer;
        this.races = races;
    }

    /**
     *
     * @return
     */
    public Race generateRace() {

        Race race = races.get(randomizer.getRandomNumber(races.size()));
        return race;
    }
    
}
