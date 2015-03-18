/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characterGenerator;

import character.CharacterSetup;
import story.ListProviderImpl;
import story.StoryCleaner;
import dwarf.DwarfAgeGenerator;
import dwarf.DwarfCityGenerator;
import dwarf.DwarfFirstnameGenerator;
import dwarf.DwarfLastnameGenerator;
import elf.ElfAgeGenerator;
import elf.ElfCityGenerator;
import elf.ElfFirstnameGenerator;
import elf.ElfLastnameGenerator;
import enums.Gender;
import enums.Race;
import interfaces.AgeGenerator;
import interfaces.CityGenerator;
import interfaces.FirstnameGenerator;
import interfaces.GenderGenerator;
import interfaces.LastnameGenerator;
import interfaces.ListProvider;
import interfaces.RaceGenerator;
import interfaces.Randomizer;
import neutralGenerators.NeutralDeityGenerator;
import neutralGenerators.NeutralGenderGenerator;
import neutralGenerators.NeutralLikesGenerator;
import neutralGenerators.NeutralPersonalityGenerator;
import neutralGenerators.NeutralRaceGenerator;
import neutralGenerators.RandomNumberGenerator;
import neutralGenerators.SeededGenerator;
import character.Character;
import story.StoryGenerator;
import story.StoryPart;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class GuiFunctions {
    
    public CharacterSetup getSetupForElf(Randomizer randomizer){
        ListProvider provider = new ListProviderImpl();
        NeutralDeityGenerator deityGenerator = new NeutralDeityGenerator(randomizer, provider.getDeityList());
        NeutralGenderGenerator genderGenerator = new NeutralGenderGenerator(randomizer, provider.getGenders());
        NeutralLikesGenerator likesGenerator = new NeutralLikesGenerator(randomizer, provider.getLikesDislikesList());
        NeutralPersonalityGenerator personalityGenerator = new NeutralPersonalityGenerator(randomizer, provider.getPersonalities());
        FirstnameGenerator firstnameGenerator = new ElfFirstnameGenerator(randomizer, provider.getElfFirstnameListM(), provider.getElfFirstnameListF());
        LastnameGenerator lastnameGenerator = new ElfLastnameGenerator(randomizer, provider.getElfLastnameList());
        AgeGenerator ageGenerator = new ElfAgeGenerator(randomizer);
        CityGenerator cityGenerator = new ElfCityGenerator(randomizer, provider.getElfCityList());
        
        return new CharacterSetup(deityGenerator, personalityGenerator, genderGenerator, likesGenerator, firstnameGenerator, lastnameGenerator, ageGenerator, cityGenerator);        
        }
    public CharacterSetup getSetupForDwarf(Randomizer randomizer){
        ListProvider provider = new ListProviderImpl();
        NeutralDeityGenerator deityGenerator = new NeutralDeityGenerator(randomizer, provider.getDeityList());
        NeutralGenderGenerator genderGenerator = new NeutralGenderGenerator(randomizer, provider.getGenders());
        NeutralLikesGenerator likesGenerator = new NeutralLikesGenerator(randomizer, provider.getLikesDislikesList());
        NeutralPersonalityGenerator personalityGenerator = new NeutralPersonalityGenerator(randomizer, provider.getPersonalities());
        FirstnameGenerator firstnameGenerator = new DwarfFirstnameGenerator(randomizer, provider.getDwarfFirstnameListM(), provider.getDwarfFirstnameListF());
        LastnameGenerator lastnameGenerator = new DwarfLastnameGenerator(randomizer, provider.getDwarfLastnamePrefixList(), provider.getDwarfLastnameSuffixList());
        AgeGenerator ageGenerator = new DwarfAgeGenerator(randomizer);
        CityGenerator cityGenerator = new DwarfCityGenerator(randomizer, provider.getDwarfCityList());
        
        return new CharacterSetup(deityGenerator, personalityGenerator, genderGenerator, likesGenerator, firstnameGenerator, lastnameGenerator, ageGenerator, cityGenerator);
    }
    public String generateStory(Character character, Randomizer randomizer) {
        ListProvider provider = new ListProviderImpl();
        StoryCleaner cleaner = new StoryCleaner(randomizer, provider);
        StoryGenerator storyGenerator = new StoryGenerator();
        
        StoryPart storypart1 = new StoryPart(provider.getPart1());
        StoryPart storypart2 = new StoryPart(provider.getPart2());
        StoryPart storypart3 = new StoryPart(provider.getPart3());
        StoryPart storypart4 = new StoryPart(provider.getPart4());
        StoryPart storypart5 = new StoryPart(provider.getPart5());
        List<StoryPart> storyparts = Arrays.asList(storypart1, storypart2, storypart3, storypart4, storypart5);
        String story2 = storyGenerator.generateStory(storyparts, cleaner, randomizer, character);
        return story2;       
    }
    public Character generateDwarf(Randomizer randomizer, Gender gender, Race race) {
        CharacterSetup characterSetup = getSetupForDwarf(randomizer);
        Character character = new Character(characterSetup, gender, race);
        return character;
    }
    public Character generateElf(Randomizer randomizer, Gender gender, Race race) {
        CharacterSetup characterSetup = getSetupForElf(randomizer);
        Character character = new Character(characterSetup, gender, race);
        return character;
    }
    public Character generateSeededCharacter(long seed) {
        ListProvider provider = new ListProviderImpl();
        Randomizer seededRandomizer = new SeededGenerator(seed);
        RaceGenerator raceGenerator = new NeutralRaceGenerator(seededRandomizer, provider.getRaces());
        Race seededRace = raceGenerator.generateRace();
        GenderGenerator genderGenerator = new NeutralGenderGenerator(seededRandomizer, provider.getGenders());
        Gender seededGender = genderGenerator.generateGender();
        Character seededCharacter;
        switch(seededRace) {
            case DWARF: seededCharacter = generateDwarf(seededRandomizer, seededGender, seededRace);
                break;
            case ELF: seededCharacter = generateElf(seededRandomizer, seededGender, seededRace);
                break;
            default: 
                throw new IllegalArgumentException("Not a valid race: " + seededRace);
        }
        seededCharacter.story = generateStory(seededCharacter, seededRandomizer);
        return seededCharacter;
    }
    public Character generateCharacter(Race race, Gender gender) {
        Character character = null;
        Randomizer randomizer = new RandomNumberGenerator();
        switch(race) {
            case DWARF: character = generateDwarf(randomizer, gender, race);
                break;
            case ELF: character = generateElf(randomizer, gender, race);
                break;
            default: 
                throw new IllegalArgumentException("Not a valid race: " + race);
        }
        character.story = generateStory(character, randomizer);
        return character;
    }
}
