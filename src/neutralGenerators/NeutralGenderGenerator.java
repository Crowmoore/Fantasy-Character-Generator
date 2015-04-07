/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutralGenerators;

import enums.Gender;
import interfaces.GenderGenerator;
import interfaces.Randomizer;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class NeutralGenderGenerator implements GenderGenerator {
    
    List<Gender> genders;
    Randomizer randomizer;
    /**
     * Constructor for NeutralGenderGenerator
     * @param randomizer
     * @param genders 
     */
    public NeutralGenderGenerator(Randomizer randomizer, List<Gender> genders) {
        this.randomizer = randomizer;
        this.genders = genders;
    }

    /**
     * Generates a random gender for a character from Gender enumerator
     * @return Gender gender
     */
    @Override
    public Gender generateGender() {

        Gender gender = genders.get(randomizer.getRandomNumber(genders.size()));
        return gender;
    }
    
}
