/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutralGenerators;

import interfaces.LikesGenerator;
import interfaces.Randomizer;
import java.util.List;

/**
 * Generates random likes/dislikes
 * @author Greatmelons
 */
public class NeutralLikesGenerator implements LikesGenerator{
     
    List<String> likesDislikesList;
    Randomizer randomizer;
    /**
     * Constructor for NeutralLikesGenerator
     * @param randomizer
     * @param likesDislikesList 
     */
    public NeutralLikesGenerator(Randomizer randomizer, List<String> likesDislikesList) {
        this.randomizer = randomizer;
        this.likesDislikesList = likesDislikesList;
    }
    /**
     * Generates a random like/dislike for a character from likesDislikesList
     * @return String like
     */
    @Override
    public String generateLikes() {
        String like = likesDislikesList.get(randomizer.getRandomNumber(likesDislikesList.size()));
        return like;
    }
    
}
