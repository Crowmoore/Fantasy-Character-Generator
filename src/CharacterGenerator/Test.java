/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator;

import CharacterGenerator.Dwarf.DwarfAgeGenerator;
import CharacterGenerator.Dwarf.DwarfCityGenerator;
import CharacterGenerator.Dwarf.DwarfFirstnameGenerator;
import CharacterGenerator.Dwarf.DwarfLastnameGenerator;
import CharacterGenerator.Elf.ElfAgeGenerator;
import CharacterGenerator.Elf.ElfCityGenerator;
import CharacterGenerator.Elf.ElfFirstnameGenerator;
import CharacterGenerator.Elf.ElfLastnameGenerator;
import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Enums.Personality;
import CharacterGenerator.Enums.Race;
import CharacterGenerator.Interfaces.AgeGenerator;
import CharacterGenerator.Interfaces.CityGenerator;
import CharacterGenerator.Interfaces.FirstnameGenerator;
import CharacterGenerator.Interfaces.LastnameGenerator;
import CharacterGenerator.Interfaces.ListProvider;
import CharacterGenerator.Interfaces.Randomizer;
import CharacterGenerator.NeutralGenerators.NeutralDeityGenerator;
import CharacterGenerator.NeutralGenerators.NeutralGenderGenerator;
import CharacterGenerator.NeutralGenerators.NeutralLikesGenerator;
import CharacterGenerator.NeutralGenerators.NeutralPersonalityGenerator;
import Story.StoryGenerator;
import CharacterGenerator.NeutralGenerators.RandomNumberGenerator;
import Characters.CharacterBase;
import Story.StoryPart;
import java.util.Arrays;
import java.util.List;

import java.util.logging.Logger;

/**
 *
 * @author Greatmelons
 */
@Deprecated
public class Test {
    
    List<Gender> genders = Arrays.asList(Gender.values());
    List<Personality> personalities = Arrays.asList(Personality.values());
    List<String> elfFirstnameListM;
    List<String> elfFirstnameListF;
    List<String> elfLastnameList;
    List<String> elfCityList;
    List<String> dwarfFirstnameListM;
    List<String> dwarfFirstnameListF;
    List<String> dwarfLastnamePrefixList;
    List<String> dwarfLastnameSuffixList;
    List<String> dwarfCityList;
    List<String> deityList;
    List<String> likesDislikesList;
    List<String> part1;
    List<String> part2;
    List<String> part3;
    List<String> part4;
    List<String> part5;
    Logger log = Logger.getLogger(Test.class.getName());
    Randomizer randomizer = new RandomNumberGenerator();
    ListProvider listProvider = new ListProviderImpl();
    StoryCleaner cleaner = new StoryCleaner(randomizer, listProvider);

    public void run() {        
        
        log.info("Starting");
        ListReader reader = new ListReader();
        elfFirstnameListM = reader.readFromFile("lists/elf/elfFirstnamesM.txt");
        elfFirstnameListF = reader.readFromFile("lists/elf/elfFirstnamesF.txt");
        elfLastnameList = reader.readFromFile("lists/elf/elfLastnames.txt");
        elfCityList = reader.readFromFile("lists/elf/elfCities.txt");
        dwarfFirstnameListM = reader.readFromFile("lists/dwarf/dwarfFirstnamesM.txt");
        dwarfFirstnameListF = reader.readFromFile("lists/dwarf/dwarfFirstnamesF.txt");
        dwarfLastnamePrefixList = reader.readFromFile("lists/dwarf/dwarfLastnamePrefix.txt");
        dwarfLastnameSuffixList = reader.readFromFile("lists/dwarf/dwarfLastnameSuffix.txt");
        dwarfCityList = reader.readFromFile("lists/dwarf/dwarfCities.txt");
        deityList = reader.readFromFile("lists/deities.txt");
        likesDislikesList = reader.readFromFile("lists/likes.txt");
        CharacterSetup elfSetup = getSetupForElf(randomizer);
        CharacterSetup dwarfSetup = getSetupForDwarf(randomizer);
        CharacterBase dwarf = new CharacterBase(dwarfSetup, Gender.FEMALE, Race.DWARF);
        CharacterBase elf = new CharacterBase(elfSetup, Gender.MALE, Race.ELF);
        String story2 = generateCharacterStory(dwarf);
        System.out.println(story2);
        
    }
    //Generates a story by using the NewStoryGenerator class
    public String generateCharacterStory(CharacterBase dwarf) {
        StoryGenerator newStoryGenerator = new StoryGenerator();
        ListReader reader = new ListReader();
        part1 = reader.readFromFile("lists/story/part1.txt");
        part2 = reader.readFromFile("lists/story/part2.txt");
        part3 = reader.readFromFile("lists/story/part3.txt");
        part4 = reader.readFromFile("lists/story/part4.txt");
        part5 = reader.readFromFile("lists/story/part5.txt");
        
        StoryPart storypart1 = new StoryPart(part1);
        StoryPart storypart2 = new StoryPart(part2);
        StoryPart storypart3 = new StoryPart(part3);
        StoryPart storypart4 = new StoryPart(part4);
        StoryPart storypart5 = new StoryPart(part5);
        List<StoryPart> storyparts = Arrays.asList(storypart1, storypart2, storypart3, storypart4, storypart5);
        String story2 = newStoryGenerator.generateStory(storyparts, cleaner, randomizer, dwarf);
        return story2;       
    }

    public CharacterSetup getSetupForElf(Randomizer randomizer){
        
        NeutralDeityGenerator deityGenerator = new NeutralDeityGenerator(randomizer, deityList);
        NeutralGenderGenerator genderGenerator = new NeutralGenderGenerator(randomizer, genders);
        NeutralLikesGenerator likesGenerator = new NeutralLikesGenerator(randomizer, likesDislikesList);
        NeutralPersonalityGenerator personalityGenerator = new NeutralPersonalityGenerator(randomizer, personalities);
        FirstnameGenerator firstnameGenerator = new ElfFirstnameGenerator(randomizer, elfFirstnameListM, elfFirstnameListF);
        LastnameGenerator lastnameGenerator = new ElfLastnameGenerator(randomizer, elfLastnameList);
        AgeGenerator ageGenerator = new ElfAgeGenerator(randomizer);
        CityGenerator cityGenerator = new ElfCityGenerator(randomizer, elfCityList);
        
        return new CharacterSetup(deityGenerator, personalityGenerator, genderGenerator, likesGenerator, firstnameGenerator, lastnameGenerator, ageGenerator, cityGenerator);
    }
    public CharacterSetup getSetupForDwarf(Randomizer randomizer){
        
        NeutralDeityGenerator deityGenerator = new NeutralDeityGenerator(randomizer, deityList);
        NeutralGenderGenerator genderGenerator = new NeutralGenderGenerator(randomizer, genders);
        NeutralLikesGenerator likesGenerator = new NeutralLikesGenerator(randomizer, likesDislikesList);
        NeutralPersonalityGenerator personalityGenerator = new NeutralPersonalityGenerator(randomizer, personalities);
        FirstnameGenerator firstnameGenerator = new DwarfFirstnameGenerator(randomizer, dwarfFirstnameListM, dwarfFirstnameListF);
        LastnameGenerator lastnameGenerator = new DwarfLastnameGenerator(randomizer, dwarfLastnamePrefixList, dwarfLastnameSuffixList);
        AgeGenerator ageGenerator = new DwarfAgeGenerator(randomizer);
        CityGenerator cityGenerator = new DwarfCityGenerator(randomizer, dwarfCityList);
        
        return new CharacterSetup(deityGenerator, personalityGenerator, genderGenerator, likesGenerator, firstnameGenerator, lastnameGenerator, ageGenerator, cityGenerator);
    }
}
