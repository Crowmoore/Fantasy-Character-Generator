/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Elf;

import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Interfaces.FirstnameGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class ElfFirstnameGenerator implements FirstnameGenerator{
    
    List<String> elfFirstnameListM;
    List<String> elfFirstnameListF;
    Randomizer randomizer;

    public ElfFirstnameGenerator(Randomizer randomizer, List<String> maleNames, List<String> femaleNames) {
        this.randomizer = randomizer;
        this.elfFirstnameListF = femaleNames;
        this.elfFirstnameListM = maleNames;
    }
    /**
     *
     * @param gender
     * @return
     */
    @Override
    public String generateFirstname(Gender gender) {
        switch(gender) {
            case MALE: return elfFirstnameListM.get(randomizer.getRandomNumber(elfFirstnameListM.size()));
            default: return elfFirstnameListF.get(randomizer.getRandomNumber(elfFirstnameListF.size()));
        }
    }
    
}
