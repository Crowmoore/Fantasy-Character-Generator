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
    
    List<String> elfFirstnameListM = Arrays.asList("Aquilan", "Drannor", "Delsaran", "Khatar", "Ailmon", "Orym", "Ailmer", "Estelar", "Voron", "Teirist", "Mirthal", "Ralikanthae", "Ayen", "Falael", "Delmuth", "Erendriel");
    List<String> elfFirstnameListF = Arrays.asList("Melladiel", "Amonthea", "Mordiliel", "Arwyn", "Aniel", "Amaranna", "Limya", "Minnathiel", "Tirenmiriel", "Issidhwen", "Melaleth");
    Randomizer randomizer;

    public ElfFirstnameGenerator(Randomizer randomizer) {
        this.randomizer = randomizer;
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
