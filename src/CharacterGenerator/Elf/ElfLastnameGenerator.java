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
    
    List<String> elfLastnameList = Arrays.asList("Rololinde", "Nhatanthar", "Isiliethor", "Mithlithdal", "Lartansel", "Neltanda", "Gwaeth", "Faelandalan", "Elerval", "Talbrinthor", "Nhaethelen");

    Randomizer randomizer;

    public ElfLastnameGenerator(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    public String generateLastname() {
        
        String lastname = elfLastnameList.get(randomizer.getRandomNumber(elfLastnameList.size()));
        return lastname;
    }
}
