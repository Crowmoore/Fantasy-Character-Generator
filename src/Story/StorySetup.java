/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Story;

import CharacterGenerator.Interfaces.ListProvider;
import CharacterGenerator.Interfaces.Randomizer;
import CharacterGenerator.ListProviderImpl;
import CharacterGenerator.ListReader;
import CharacterGenerator.StoryCleaner;
import Characters.CharacterBase;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class StorySetup {
    
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
        String story = storyGenerator.generateStory(storyparts, cleaner, randomizer, character);
        return story;       
    }
    
}
