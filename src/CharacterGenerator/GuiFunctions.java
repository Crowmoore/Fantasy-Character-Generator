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
import Characters.CharacterBase;
import Story.StoryGenerator;
import Story.StoryPart;
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
    public String generateStory(CharacterBase character, Randomizer randomizer) {
        ListProvider provider = new ListProviderImpl();
        StoryCleaner cleaner = new StoryCleaner(randomizer, provider);
        StoryGenerator storyGenerator = new StoryGenerator();
        ListReader reader = new ListReader();
        
        StoryPart storypart1 = new StoryPart(provider.getPart1());
        StoryPart storypart2 = new StoryPart(provider.getPart2());
        StoryPart storypart3 = new StoryPart(provider.getPart3());
        StoryPart storypart4 = new StoryPart(provider.getPart4());
        StoryPart storypart5 = new StoryPart(provider.getPart5());
        List<StoryPart> storyparts = Arrays.asList(storypart1, storypart2, storypart3, storypart4, storypart5);
        String story2 = storyGenerator.generateStory(storyparts, cleaner, randomizer, character);
        return story2;       
    }
    public CharacterBase generateDwarf(Randomizer randomizer, Gender gender, Race race) {
        CharacterSetup characterSetup = getSetupForDwarf(randomizer);
        CharacterBase character = new CharacterBase(characterSetup, gender, race);
        return character;
    }
    public CharacterBase generateElf(Randomizer randomizer, Gender gender, Race race) {
        CharacterSetup characterSetup = getSetupForElf(randomizer);
        CharacterBase character = new CharacterBase(characterSetup, gender, race);
        return character;
    }    
}
