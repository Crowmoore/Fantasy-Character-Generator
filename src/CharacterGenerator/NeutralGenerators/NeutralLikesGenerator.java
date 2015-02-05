/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.NeutralGenerators;

import CharacterGenerator.Interfaces.LikesGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class NeutralLikesGenerator implements LikesGenerator{
     
    List<String> likesDislikesList = Arrays.asList("goblins", "dragons", "spiders", "insects", "fruits", "death", "animals", "swords", "legendary folklore", "drunkness", "ale", "rock punishing", "fighting", "birds", "shiny things", "torture", "nails", "sharp things", "holidays", "ugliness", "fish", "magic", "sorcerers", "undead things", "dungeon crawling", "looting", "raiding", "loud noises", "dark and wet places", "spirits of ancestors", "high places", "snow", "mining");

    Randomizer randomizer;

    public NeutralLikesGenerator(Randomizer randomizer) {
        this.randomizer = randomizer;
    }
    /**
     *
     * @return
     */
    @Override
    public String generateLikes() {
        String likes = likesDislikesList.get(randomizer.getRandomNumber(likesDislikesList.size()));
        return likes;
    }
    
}
