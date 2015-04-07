/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import character.Character;
import java.util.List;
import story.StoryCleaner;
import story.StoryPart;

/**
 *
 * @author Greatmelons
 */
public interface StoryGenerator {
    
    /**
     * Abstract method generateStory
     * @param storyparts
     * @param cleaner
     * @param randomizer
     * @param character
     * @return String
     */
    public String generateStory(List<StoryPart> storyparts, StoryCleaner cleaner, Randomizer randomizer, Character character);
    
}
