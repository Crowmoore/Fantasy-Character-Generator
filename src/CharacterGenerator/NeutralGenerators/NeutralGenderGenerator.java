/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.NeutralGenerators;

import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Interfaces.GenderGenerator;
import CharacterGenerator.Interfaces.Randomizer;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class NeutralGenderGenerator implements GenderGenerator {
    
    Randomizer randomizer;
    
    public NeutralGenderGenerator(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    /**
     *
     * @return
     */
    @Override
    public Gender generateGender() {

        List<Gender> genders = Arrays.asList(Gender.values());

        Gender gender = genders.get(randomizer.getRandomNumber(genders.size()));
        return gender;
    }
    
}
