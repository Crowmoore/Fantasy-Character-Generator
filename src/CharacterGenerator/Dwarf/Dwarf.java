/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Dwarf;

import CharacterGenerator.NeutralGenerators.NeutralGenderGenerator;
import CharacterGenerator.NeutralGenerators.NeutralLikesGenerator;

/**
 *
 * @author Greatmelons
 */
public class Dwarf {

    private final NeutralLikesGenerator likesGenerator;
    private final DwarfFirstnameGenerator firstnameGenerator;
    private final DwarfLastnameGenerator lastnameGenerator;
    private final DwarfAgeGenerator ageGenerator;
    private final DwarfCityGenerator cityGenerator;
    private final NeutralGenderGenerator genderGenerator;
    private String firstname;
    private String lastname;
    private String city;
    private String likes;
    private String gender;
    private int age;
    
    public Dwarf() {
        
        genderGenerator = new NeutralGenderGenerator();
        likesGenerator = new NeutralLikesGenerator();
        cityGenerator = new DwarfCityGenerator();
        ageGenerator = new DwarfAgeGenerator();
        firstnameGenerator = new DwarfFirstnameGenerator();
        lastnameGenerator = new DwarfLastnameGenerator();
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