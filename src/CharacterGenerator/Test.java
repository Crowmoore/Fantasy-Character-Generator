/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator;

import CharacterGenerator.Dwarf.Dwarf;
import CharacterGenerator.Dwarf.DwarfGenerator;
import CharacterGenerator.Elf.Elf;
import CharacterGenerator.Elf.ElfAgeGenerator;
import CharacterGenerator.Elf.ElfCityGenerator;
import CharacterGenerator.Elf.ElfFirstnameGenerator;
import CharacterGenerator.Elf.ElfLastnameGenerator;
import CharacterGenerator.Interfaces.AgeGenerator;
import CharacterGenerator.Interfaces.CityGenerator;
import CharacterGenerator.Interfaces.FirstnameGenerator;
import CharacterGenerator.Interfaces.LastnameGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import CharacterGenerator.NeutralGenerators.NeutralDeityGenerator;
import CharacterGenerator.NeutralGenerators.NeutralGenderGenerator;
import CharacterGenerator.NeutralGenerators.NeutralLikesGenerator;
import CharacterGenerator.NeutralGenerators.NeutralPersonalityGenerator;
import CharacterGenerator.NeutralGenerators.NeutralRaceGenerator;
import CharacterGenerator.NeutralGenerators.NeutralStoryGenerator;
import CharacterGenerator.NeutralGenerators.RandomNumberGenerator;
import java.util.Arrays;
import java.util.List;

import java.util.logging.Logger;

/**
 *
 * @author Greatmelons
 */
public class Test {

    List<String> likesDislikesList = Arrays.asList("goblins", "dragons", "spiders", "insects", "fruits", "death", "animals", "swords", "legendary folklore", "drunkness", "ale", "rock punishing", "fighting", "birds", "shiny things", "torture", "nails", "sharp things", "holidays", "ugliness", "fish", "magic", "sorcerers", "undead things", "dungeon crawling", "looting", "raiding", "loud noises", "dark and wet places", "spirits of ancestors", "high places", "snow", "mining");
    Logger log = Logger.getLogger(Test.class.getName());
    Randomizer randomizer = new RandomNumberGenerator();
    StoryCleaner cleaner = new StoryCleaner(randomizer);
    DwarfGenerator dwarfGenerator = new DwarfGenerator();
    NeutralStoryGenerator storyGenerator = new NeutralStoryGenerator(randomizer, cleaner);
    
    public void run() {        
        
        log.info("Starting");
        
        CharacterSetup elfSetup = getSetupForElf(randomizer);
        Dwarf dwarf = dwarfGenerator.generateCharacter(randomizer, likesDislikesList);
        Elf elf = new Elf(elfSetup);
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
    public CharacterSetup getSetupForElf(Randomizer randomizer){
        
        NeutralDeityGenerator deityGenerator = new NeutralDeityGenerator(randomizer);
        NeutralGenderGenerator genderGenerator = new NeutralGenderGenerator(randomizer);
        NeutralLikesGenerator likesGenerator = new NeutralLikesGenerator(randomizer, likesDislikesList);
        NeutralPersonalityGenerator personalityGenerator = new NeutralPersonalityGenerator(randomizer);
        FirstnameGenerator firstnameGenerator = new ElfFirstnameGenerator(randomizer);
        LastnameGenerator lastnameGenerator = new ElfLastnameGenerator(randomizer);
        AgeGenerator ageGenerator = new ElfAgeGenerator(randomizer);
        CityGenerator cityGenerator = new ElfCityGenerator(randomizer);
        
        return new CharacterSetup(deityGenerator, personalityGenerator, genderGenerator, likesGenerator, firstnameGenerator, lastnameGenerator, ageGenerator, cityGenerator);
    }
}
