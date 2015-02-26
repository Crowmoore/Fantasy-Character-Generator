/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Story;

import CharacterGenerator.Interfaces.Randomizer;
import CharacterGenerator.StoryCleaner;
import Characters.CharacterBase;
import Story.StoryPart;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class StoryGenerator {
    
    
    public String generateStory(List<StoryPart> storyparts, StoryCleaner cleaner, Randomizer randomizer, CharacterBase character) {
        String story = "";
        String finalStory = "";
        for(StoryPart storypart : storyparts) {
            story = (storypart.getSentence(randomizer) + "\n");
            finalStory += cleaner.cleanSentence(story, character);
            if(story.contains("died"))
                break;
        }
        return finalStory;
    }
    
}
