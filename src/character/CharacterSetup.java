/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import interfaces.AgeGenerator;
import interfaces.CityGenerator;
import interfaces.DeityGenerator;
import interfaces.FirstnameGenerator;
import interfaces.GenderGenerator;
import interfaces.LastnameGenerator;
import interfaces.LikesGenerator;
import interfaces.PersonalityGenerator;
import story.StoryGenerator;

/**
 *
 * @author Greatmelons
 */
public class CharacterSetup {

    DeityGenerator deityGenerator;
    GenderGenerator genderGenerator;
    LikesGenerator likesGenerator;
    PersonalityGenerator personalityGenerator;
    FirstnameGenerator firstnameGenerator;
    LastnameGenerator lastnameGenerator;
    AgeGenerator ageGenerator;
    CityGenerator cityGenerator;
    StoryGenerator storyGenerator;
    
    /**
     * Constructor for CharacterSetup
     * @param deityGenerator
     * @param personalityGenerator
     * @param genderGenerator
     * @param likesGenerator
     * @param firstnameGenerator
     * @param lastnameGenerator
     * @param ageGenerator
     * @param cityGenerator 
     */
    public CharacterSetup(
            DeityGenerator deityGenerator,
            PersonalityGenerator personalityGenerator,
            GenderGenerator genderGenerator,
            LikesGenerator likesGenerator,
            FirstnameGenerator firstnameGenerator,
            LastnameGenerator lastnameGenerator,
            AgeGenerator ageGenerator,
            CityGenerator cityGenerator) {

        this.deityGenerator = deityGenerator;
        this.ageGenerator = ageGenerator;
        this.cityGenerator = cityGenerator;
        this.firstnameGenerator = firstnameGenerator;
        this.lastnameGenerator = lastnameGenerator;
        this.genderGenerator = genderGenerator;
        this.personalityGenerator = personalityGenerator;
        this.likesGenerator = likesGenerator;
    }
    
    public DeityGenerator getDeityGenerator() {
        return deityGenerator;
    }

    public GenderGenerator getGenderGenerator() {
        return genderGenerator;
    }

    public LikesGenerator getLikesGenerator() {
        return likesGenerator;
    }

    public PersonalityGenerator getPersonalityGenerator() {
        return personalityGenerator;
    }

    public FirstnameGenerator getFirstnameGenerator() {
        return firstnameGenerator;
    }

    public LastnameGenerator getLastnameGenerator() {
        return lastnameGenerator;
    }

    public AgeGenerator getAgeGenerator() {
        return ageGenerator;
    }

    public CityGenerator getCityGenerator() {
        return cityGenerator;
    }
    
}
