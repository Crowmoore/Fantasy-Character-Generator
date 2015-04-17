/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package story;

import interfaces.ListProvider;
import interfaces.Randomizer;
import character.Character;
import java.util.Arrays;
import java.util.List;

/**
 * Story setup class for initializing all the relevant classes needed for story generation
 * @author Greatmelons
 */
public class StorySetup {
    
    /**
     * Sets up the story generation by initializing all the relevant classes and sending them to the StoryGeneratorImpl which then returns the final story
     * @param character
     * @param randomizer
     * @return 
     */
    public String generateStory(Character character, Randomizer randomizer) {
        ListProvider provider = new ListProviderImpl();
        StoryCleaner cleaner = new StoryCleaner(randomizer, provider);
        StoryGeneratorImpl storyGenerator = new StoryGeneratorImpl();
        
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
