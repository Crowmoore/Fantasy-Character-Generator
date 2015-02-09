/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.NeutralGenerators;

import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Enums.Personality;
import CharacterGenerator.Interfaces.Randomizer;
import CharacterGenerator.Interfaces.StoryGenerator;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class NeutralStoryGenerator implements StoryGenerator{
    
    
    
    Randomizer randomizer;
    
    public NeutralStoryGenerator(Randomizer randomizer) {
        this.randomizer = randomizer;
    }
    
    public String generateStory(String firstname, String lastname, int age, Gender gender, Personality personality, String city) {
        List storyList = Arrays.asList("On a cold winter morning in " + (7850 - age) + " " + firstname + " " + lastname + " was born.", "On a hot summer in " + (7850 - age) + " " + firstname + " " + lastname + " was born.");
        String story = (String) storyList.get(randomizer.getRandomNumber(storyList.size()));
        return story;
    }
    
}
