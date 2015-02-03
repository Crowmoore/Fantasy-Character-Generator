/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator;

import NeutralGenerators.NeutralCharacterGenerator;
import NeutralGenerators.NeutralRaceGenerator;

/**
 *
 * @author Greatmelons
 */
public class Test {
    
    public void run() {        
        /*DwarfGenerator dwarfGenerator = new DwarfGenerator();
        String dwarf = dwarfGenerator.generateCharacter();
        ElfGenerator elfGenerator = new ElfGenerator();
        String elf = elfGenerator.generateCharacter();*/
        NeutralRaceGenerator raceGenerator = new NeutralRaceGenerator();
        String race = raceGenerator.generateRace();
        NeutralCharacterGenerator characterGenerator = new NeutralCharacterGenerator();
        String character = characterGenerator.generateCharacter(race);
        System.out.println(character);
    }
    
}
