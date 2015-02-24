/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Dwarf;

import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Interfaces.FirstnameGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class DwarfFirstnameGenerator implements FirstnameGenerator{
    
    List<String> dwarfFirstnameListM;
    List<String> dwarfFirstnameListF;

    Randomizer randomizer;

    public DwarfFirstnameGenerator(Randomizer randomizer, List<String> firstnamesM, List<String> firstnamesF) {
        this.randomizer = randomizer;
        this.dwarfFirstnameListM = firstnamesM;
        this.dwarfFirstnameListF = firstnamesF;
    }
    /**
     *
     * @param gender
     * @return
     */
    @Override
    public String generateFirstname(Gender gender) {
        String firstname;
        switch(gender) {
            case MALE: return dwarfFirstnameListM.get(randomizer.getRandomNumber(dwarfFirstnameListM.size()));
            default: return dwarfFirstnameListF.get(randomizer.getRandomNumber(dwarfFirstnameListF.size()));
        }
    }
    
}
