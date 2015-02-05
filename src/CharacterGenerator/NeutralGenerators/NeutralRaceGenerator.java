/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.NeutralGenerators;

import CharacterGenerator.Interfaces.RaceGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class NeutralRaceGenerator implements RaceGenerator{
    
    List<String> raceList = Arrays.asList("Dwarf", "Elf");

    Randomizer randomizer;
    //Dependency injection = DI
    public NeutralRaceGenerator(Randomizer randomizer) {
        this.randomizer = randomizer;
    }
    /**
     *
     * @return
     */
    @Override
    public String generateRace() {
        String race = raceList.get(randomizer.getRandomNumber(raceList.size()));
        return race;
    }
    
}
