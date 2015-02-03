/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Elf;

import CharacterGenerator.Interfaces.AgeGenerator;
import CharacterGenerator.Interfaces.Randomizer;

/**
 *
 * @author Greatmelons
 */
public class ElfAgeGenerator implements AgeGenerator, Randomizer {
    
    /**
     *
     * @return
     */
    @Override
    public int generateAge() {
        int age = randomizer.nextInt(5000);
        return age;
    }
    
}
