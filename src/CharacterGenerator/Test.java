/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator;

import CharacterGenerator.Dwarf.Dwarf;
import CharacterGenerator.Dwarf.DwarfGenerator;
import CharacterGenerator.Elf.ElfGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import CharacterGenerator.NeutralGenerators.NeutralRaceGenerator;
import CharacterGenerator.NeutralGenerators.NeutralStoryGenerator;
import CharacterGenerator.NeutralGenerators.RandomNumberGenerator;

import java.util.logging.Logger;

/**
 *
 * @author Greatmelons
 */
public class Test {

    Logger log = Logger.getLogger(Test.class.getName());

    public void run() {        
        
        log.info("Starting");
        Randomizer randomizer = new RandomNumberGenerator();
        ElfGenerator elfGenerator = new ElfGenerator();
        DwarfGenerator dwarfGenerator = new DwarfGenerator();
        NeutralStoryGenerator storyGenerator = new NeutralStoryGenerator(randomizer);
        Dwarf dwarf = dwarfGenerator.generateCharacter();
        String elf = elfGenerator.generateCharacter();
        System.out.println(elf);
        String story = storyGenerator.generateStory(dwarf.getFirstname(),
                                                    dwarf.getLastname(),
                                                    dwarf.getAge(),
                                                    dwarf.getGender(),
                                                    dwarf.getPersonality(),
                                                    dwarf.getCity());
        System.out.println(story);
    }
    
}
