/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator;

import CharacterGenerator.Dwarf.Dwarf;
import CharacterGenerator.Dwarf.DwarfGenerator;
import CharacterGenerator.Elf.Elf;
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
    Randomizer randomizer = new RandomNumberGenerator();
    StoryCleaner cleaner = new StoryCleaner(randomizer);
    ElfGenerator elfGenerator = new ElfGenerator();
    DwarfGenerator dwarfGenerator = new DwarfGenerator();
    NeutralStoryGenerator storyGenerator = new NeutralStoryGenerator(randomizer, cleaner);
    
    public void run() {        
        
        log.info("Starting");
        
        Dwarf dwarf = dwarfGenerator.generateCharacter();
        Elf elf = elfGenerator.generateCharacter();
        String elfStory = generateElfStory(elf);
        log.info("Generated a story for elf");
        String dwarfStory = generateDwarfStory(dwarf);
        log.info("Generated a story for dwarf");
        System.out.printf("%s\n\n%s\n", elfStory, dwarfStory);
    }
    public String generateElfStory(Elf elf) {
        String elfStory = storyGenerator.generateStory(elf.getFirstname(),
                                                    elf.getLastname(),
                                                    elf.getAge(),
                                                    elf.getGender(),
                                                    elf.getPersonality(),
                                                    elf.getCity(),
                                                    elf.getLikes(),
                                                    elf.getDeity());
        return elfStory;
    }
    public String generateDwarfStory(Dwarf dwarf) {
        String dwarfStory = storyGenerator.generateStory(dwarf.getFirstname(),
                                                    dwarf.getLastname(),
                                                    dwarf.getAge(),
                                                    dwarf.getGender(),
                                                    dwarf.getPersonality(),
                                                    dwarf.getCity(),
                                                    dwarf.getLikes(),
                                                    dwarf.getDeity());
        return dwarfStory;
    }
    
}
