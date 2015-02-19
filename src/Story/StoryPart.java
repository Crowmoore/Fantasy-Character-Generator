/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Story;

import CharacterGenerator.Interfaces.Randomizer;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class StoryPart {
    
    List<String> sentences;
    
    public StoryPart(List<String> sentences) {
        
        this.sentences = sentences;
        
    }
    
    public String getSentences(Randomizer randomizer) {
        return sentences.get(randomizer.getRandomNumber(sentences.size()));
    }
}
