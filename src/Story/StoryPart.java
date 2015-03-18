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
    
    public StoryPart(List<String> sentences) {
        
        this.sentences = sentences;
        
    }
    
    public String getSentence(Randomizer randomizer) {
        return sentences.get(randomizer.getRandomNumber(sentences.size()));
    }
}
