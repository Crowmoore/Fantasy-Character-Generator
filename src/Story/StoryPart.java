/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package story;

import interfaces.Randomizer;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class StoryPart {
    
    private List<String> sentences;
    
    /**
     * Constructor for StoryPart
     * @param sentences 
     */
    public StoryPart(List<String> sentences) {
        
        this.sentences = sentences;
        
    }
    /**
     * Get a random sentence from List<String> sentences
     * @param randomizer
     * @return String sentence
     */
    public String getSentence(Randomizer randomizer) {
        return sentences.get(randomizer.getRandomNumber(sentences.size()));
    }
}
