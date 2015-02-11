/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Elf;

import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Enums.Personality;
import CharacterGenerator.NeutralGenerators.NeutralDeityGenerator;
import CharacterGenerator.NeutralGenerators.NeutralGenderGenerator;
import CharacterGenerator.NeutralGenerators.NeutralLikesGenerator;
import CharacterGenerator.NeutralGenerators.NeutralPersonalityGenerator;

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
    private Personality personality;
    private int age;
    private String deity;
    
    public Elf(
            NeutralDeityGenerator deityGenerator,
            NeutralPersonalityGenerator personalityGenerator,
            NeutralGenderGenerator genderGenerator,
            NeutralLikesGenerator likesGenerator,
            ElfFirstnameGenerator firstnameGenerator,
            ElfLastnameGenerator lastnameGenerator,
            ElfAgeGenerator ageGenerator,
            ElfCityGenerator cityGenerator) {

        personality = personalityGenerator.generatePersonality();
        gender = genderGenerator.generateGender();
        firstname = firstnameGenerator.generateFirstname(gender);
        lastname = lastnameGenerator.generateLastname();
        city = cityGenerator.generateCity();
        likes = likesGenerator.generateLikes();
        age = ageGenerator.generateAge();
    }
    public Personality getPersonality() {
        return personality;
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
    public String getDeity() {
        return deity;
    }
}