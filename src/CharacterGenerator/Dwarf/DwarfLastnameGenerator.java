/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Dwarf;

import CharacterGenerator.Interfaces.LastnameGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class DwarfLastnameGenerator implements LastnameGenerator {
    
    List<String> dwarfLastnamePrefixList = Arrays.asList("Oak", "Frost", "Thunder", "Fire", "Ground", "Iron", "Stone", "Sword", "Blood", "Red", "Anvil", "Gray", "Foe", "Strong", "Troll", "Orc", "Serpent", "Snake");
    List<String> dwarfLastnameSuffixList = Arrays.asList("shield", "rock", "heart", "hammer", "forger", "shadow", "breaker", "beard", "axe", "fist", "bane", "caster", "crusher", "eye", "mind");

    Randomizer randomizer;

    public DwarfLastnameGenerator(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    public String generateLastname() {
        
        String lastnamePre = dwarfLastnamePrefixList.get(randomizer.getRandomNumber(dwarfLastnamePrefixList.size()));
        String lastnameSuf = dwarfLastnameSuffixList.get(randomizer.getRandomNumber(dwarfLastnameSuffixList.size()));
        return lastnamePre + lastnameSuf;
    }
}
