/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.NeutralGenerators;

import CharacterGenerator.Interfaces.Randomizer;
import CharacterGenerator.StoryCleaner;
import Characters.CharacterBase;
import Story.StoryPart;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class NewStoryGenerator {
    
    
    public String generateStory(List<StoryPart> storyparts, StoryCleaner cleaner, Randomizer randomizer, CharacterBase character) {
        String story = "";
        for(StoryPart storypart : storyparts) {
            story += (storypart.getSentences(randomizer) + "\n");
        }
        story = cleaner.cleanSentence(story, character);
        return story;
    }
    
}
