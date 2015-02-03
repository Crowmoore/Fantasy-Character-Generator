/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Elf;

import CharacterGenerator.NeutralGenerators.NeutralGenderGenerator;
import CharacterGenerator.NeutralGenerators.NeutralLikesGenerator;

/**
 *
 * @author Greatmelons
 */
public class Elf {

    private final NeutralLikesGenerator likesGenerator;
    private final ElfFirstnameGenerator firstnameGenerator;
    private final ElfLastnameGenerator lastnameGenerator;
    private final ElfAgeGenerator ageGenerator;
    private final ElfCityGenerator cityGenerator;
    private final NeutralGenderGenerator genderGenerator;
    private String firstname;
    private String lastname;
    private String city;
    private String likes;
    private String gender;
    private int age;
    
    public Elf() {
        
        genderGenerator = new NeutralGenderGenerator();
        likesGenerator = new NeutralLikesGenerator();
        cityGenerator = new ElfCityGenerator();
        ageGenerator = new ElfAgeGenerator();
        firstnameGenerator = new ElfFirstnameGenerator();
        lastnameGenerator = new ElfLastnameGenerator();
        gender = "";
        firstname = "";
        lastname = "";
        city = "";
        likes = "";
        age = 0;
    }
    public String getGender() {
        gender = genderGenerator.generateGender();
        return gender;
    }
    public String getFirstname(String gender) {
        firstname = firstnameGenerator.generateFirstname(gender);
        return firstname;
    }
    public String getLastname() {
        lastname = lastnameGenerator.generateLastname();
        return lastname;
    }
    public String getCity() {
        city = cityGenerator.generateCity();
        return city;
    }
    public int getAge() {
        age = ageGenerator.generateAge();
        return age;
    }
    public String getLikes() {
        likes = likesGenerator.generateLikes();
        return likes;
    }
}