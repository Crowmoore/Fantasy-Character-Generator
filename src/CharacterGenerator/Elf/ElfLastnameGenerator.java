/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Elf;

import CharacterGenerator.Interfaces.LastnameGenerator;
import CharacterGenerator.Interfaces.Randomizer;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class ElfLastnameGenerator implements LastnameGenerator {
    
    List<String> elfLastnameList;

    Randomizer randomizer;

    public ElfLastnameGenerator(Randomizer randomizer, List<String> lastnameList) {
        this.randomizer = randomizer;
        this.elfLastnameList = lastnameList;
    }

    public String generateLastname() {
        
        String lastname = elfLastnameList.get(randomizer.getRandomNumber(elfLastnameList.size()));
        return lastname;
    }
}
