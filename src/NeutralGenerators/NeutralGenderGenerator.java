/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NeutralGenerators;

import CharacterGenerator.Interfaces.GenderGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class NeutralGenderGenerator implements GenderGenerator, Randomizer {
    
    List<String> genderList = Arrays.asList("Male", "Female");
    
    public String generateGender() {
        String gender = genderList.get(randomizer.nextInt(genderList.size()));
        return gender;
    }
    
}
