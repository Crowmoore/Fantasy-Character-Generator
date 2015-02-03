/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Elf;

import CharacterGenerator.Interfaces.FirstnameGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class ElfFirstnameGenerator implements FirstnameGenerator, Randomizer {
    
    List<String> elfFirstnameListM = Arrays.asList("Aquilan", "Drannor", "Delsaran", "Khatar", "Ailmon", "Orym", "Ailmer", "Estelar", "Voron", "Teirist", "Mirthal", "Ralikanthae", "Ayen", "Falael", "Delmuth", "Erendriel");
    List<String> elfFirstnameListF = Arrays.asList("Melladiel", "Amonthea", "Mordiliel", "Arwyn", "Aniel", "Amaranna", "Limya", "Minnathiel", "Tirenmiriel", "Issidhwen", "Melaleth");
            
    /**
     *
     * @param gender
     * @return
     */
    @Override
    public String generateFirstname(String gender) {
        if ("Male".equals(gender)) {
            String firstname = elfFirstnameListM.get(randomizer.nextInt(elfFirstnameListM.size()));
            return firstname;
        }
        else {
            String firstname = elfFirstnameListF.get(randomizer.nextInt(elfFirstnameListF.size()));
            return firstname;
        }
    }
    
}
