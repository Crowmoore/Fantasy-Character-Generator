/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import enums.Gender;
import enums.Personality;
import character.Character;

/**
 *
 * @author Greatmelons
 */
public interface StoryGenerator {
    
    public String generateStory(Character characterBase);//(String firstname, String lastname, int age, Gender gender, Personality personality, String city, String likes, String deity);
    
}
