/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package story;

import interfaces.Randomizer;
import character.Character;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class StoryGenerator {
    
    
    public String generateStory(List<StoryPart> storyparts, StoryCleaner cleaner, Randomizer randomizer, Character character) {
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
