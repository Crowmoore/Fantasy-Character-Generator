/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package story;

import interfaces.Randomizer;
import character.Character;
import interfaces.StoryGenerator;
import java.util.List;

/**
 * Generates a full story for a character
 * @author Greatmelons
 */
public class StoryGeneratorImpl implements StoryGenerator{
    
    /**
     * Generates a story sentence by sentence from List<StoryPart> storyparts until a sentence contains a word "died" or there are no more story parts
     * @param storyparts
     * @param cleaner
     * @param randomizer
     * @param character
     * @return String finalStory
     */
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
