/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutralGenerators;

import interfaces.LikesGenerator;
import interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class NeutralLikesGenerator implements LikesGenerator{
     
    List<String> likesDislikesList;
    Randomizer randomizer;

    public NeutralLikesGenerator(Randomizer randomizer, List<String> likesDislikesList) {
        this.randomizer = randomizer;
        this.likesDislikesList = likesDislikesList;
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
