/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Elf;

import character.CharacterSetup;
import enums.Gender;
import enums.Personality;
import enums.Race;
import interfaces.AgeGenerator;
import interfaces.CityGenerator;
import interfaces.DeityGenerator;
import interfaces.FirstnameGenerator;
import interfaces.GenderGenerator;
import interfaces.LastnameGenerator;
import interfaces.LikesGenerator;
import interfaces.PersonalityGenerator;
import interfaces.RaceGenerator;
import character.Character;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author Greatmelons
 */
public class ElfTest {

    DeityGenerator deityGenerator;
    GenderGenerator genderGenerator;
    LikesGenerator likesGenerator;
    PersonalityGenerator personalityGenerator;
    FirstnameGenerator firstnameGenerator;
    LastnameGenerator lastnameGenerator;
    AgeGenerator ageGenerator;
    CityGenerator cityGenerator;
    RaceGenerator raceGenerator;
    
    @Before
    public void setup() {
        deityGenerator = mock(DeityGenerator.class);
        genderGenerator = mock(GenderGenerator.class);
        likesGenerator = mock(LikesGenerator.class);
        personalityGenerator = mock(PersonalityGenerator.class);
        firstnameGenerator = mock(FirstnameGenerator.class);
        lastnameGenerator = mock(LastnameGenerator.class);
        ageGenerator = mock(AgeGenerator.class);
        cityGenerator = mock(CityGenerator.class);
        raceGenerator = mock(RaceGenerator.class);
        
                
    }
    @Test
    public void testElfGeneratedCorrectly() {
        //Arrange
        String expectedDeity = "God";
        Gender expectedGender = Gender.MALE;
        Race expectedRace = Race.ELF;
        String expectedLike = "Fish";
        Personality expectedPersonality = Personality.CALM;
        String expectedFirstname = "Harry";
        String expectedLastname = "Hairy";
        int expectedAge = 25;
        String expectedCity = "Helsinki";
        when(deityGenerator.generateDeity()).thenReturn(expectedDeity);
        when(genderGenerator.generateGender()).thenReturn(expectedGender);
        when(raceGenerator.generateRace()).thenReturn(expectedRace);
        when(likesGenerator.generateLikes()).thenReturn(expectedLike);
        when(personalityGenerator.generatePersonality()).thenReturn(expectedPersonality);
        when(firstnameGenerator.generateFirstname(Gender.MALE)).thenReturn(expectedFirstname);
        when(lastnameGenerator.generateLastname()).thenReturn(expectedLastname);
        when(ageGenerator.generateAge()).thenReturn(expectedAge);
        when(cityGenerator.generateCity()).thenReturn(expectedCity);
        CharacterSetup setup = new CharacterSetup(deityGenerator, personalityGenerator, genderGenerator, likesGenerator, firstnameGenerator, lastnameGenerator, ageGenerator, cityGenerator);
        //Act
        Character elf = new Character(setup, expectedGender, expectedRace);
        String actualDeity = elf.getDeity();
        Gender actualGender = elf.getGender();
        String actualLike = elf.getLikes();
        Personality actualPersonality = elf.getPersonality();
        String actualFirstname = elf.getFirstname();
        String actualLastname = elf.getLastname();
        int actualAge = elf.getAge();
        String actualCity = elf.getCity();
        //Assert
        assertEquals(expectedDeity, actualDeity);
        assertEquals(expectedGender, actualGender);
        assertEquals(expectedLike, actualLike);
        assertEquals(expectedPersonality, actualPersonality);
        assertEquals(expectedFirstname, actualFirstname);
        assertEquals(expectedLastname, actualLastname);
        assertEquals(expectedAge, actualAge);
        assertEquals(expectedCity, actualCity);
    }
}
