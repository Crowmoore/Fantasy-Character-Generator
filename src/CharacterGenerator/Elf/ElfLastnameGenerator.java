/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Elf;

import static CharacterGenerator.Interfaces.Randomizer.randomizer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class ElfLastnameGenerator {
    
    List<String> elfLastnameList = Arrays.asList("Rololinde", "Nhatanthar", "Isiliethor", "Mithlithdal", "Lartansel", "Neltanda", "Gwaeth", "Faelandalan", "Elerval", "Talbrinthor", "Nhaethelen");
    
    public String generateLastname() {
        
        String lastname = elfLastnameList.get(randomizer.nextInt(elfLastnameList.size()));
        return lastname;
    }
}
