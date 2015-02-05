/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Elf;

import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Interfaces.*;
import CharacterGenerator.NeutralGenerators.NeutralGenderGenerator;
import CharacterGenerator.NeutralGenerators.NeutralLikesGenerator;

/**
 *
 * @author Greatmelons
 */
public class Elf {

    private String firstname;
    private String lastname;
    private String city;
    private String likes;
    private Gender gender;
    private int age;
    
    public Elf(
            NeutralGenderGenerator genderGenerator,
            NeutralLikesGenerator likesGenerator,
            FirstnameGenerator firstnameGenerator,
            LastnameGenerator lastnameGenerator,
            AgeGenerator ageGenerator,
            CityGenerator cityGenerator) {

        gender = genderGenerator.generateGender();
        firstname = firstnameGenerator.generateFirstname(gender);
        lastname = lastnameGenerator.generateLastname();
        city = cityGenerator.generateCity();
        likes = likesGenerator.generateLikes();
        age = ageGenerator.generateAge();
    }
    public Gender getGender() {
        return gender;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getCity() {
        return city;
    }
    public int getAge() {
        return age;
    }
    public String getLikes() {
        return likes;
    }
}