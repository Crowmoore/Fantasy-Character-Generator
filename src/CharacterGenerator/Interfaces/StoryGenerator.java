/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Interfaces;

import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Enums.Personality;

/**
 *
 * @author Greatmelons
 */
public interface StoryGenerator {
    
    public String generateStory(String firstname, String lastname, int age, Gender gender, Personality personality, String city, String likes, String deity);
    
}
