/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import enums.Gender;
import enums.Personality;
import enums.Race;
import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Greatmelons
 */
public class Character implements Serializable {
    
    private Personality personality;
    private String firstname;
    private String lastname;
    private String city;
    private String likes;
    private Gender gender;
    private ImageIcon image;

    private int age;
    private String deity;
    private Race race;
    public String story;
    
    public Character(CharacterSetup setup, Gender gender, Race race) {
        personality = setup.getPersonalityGenerator().generatePersonality();
        this.gender = gender;
        this.race = race;
        firstname = setup.getFirstnameGenerator().generateFirstname(gender);
        lastname = setup.getLastnameGenerator().generateLastname();
        city = setup.getCityGenerator().generateCity();
        likes = setup.getLikesGenerator().generateLikes();
        age = setup.getAgeGenerator().generateAge();
        deity = setup.getDeityGenerator().generateDeity();
        story = "";
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
    public Race getRace() {
        return race;
    }
    public String getStory() {
        return story;
    }
    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDeity(String deity) {
        this.deity = deity;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void setStory(String story) {
        this.story = story;
    }    
}
