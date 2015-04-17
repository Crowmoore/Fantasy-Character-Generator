/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.NeutralGenerators;

import neutralGenerators.NeutralPronounsGenerator;
import enums.Gender;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Greatmelons
 */
public class NeutralPronounsGeneratorTest {
    
    Gender male;
    Gender female;
    NeutralPronounsGenerator pronounsGenerator;
    
    @Before
    public void setup() {
        male = Gender.MALE;
        female = Gender.FEMALE;
        pronounsGenerator = new NeutralPronounsGenerator();
    }
    @Test
    public void testGetSubjectivePronounForMale() {
        //Arrange
        String expectedPronoun = "He";
        //Act
        String actualPronoun = pronounsGenerator.getSubjective(male);
        //Assert
        assertEquals(expectedPronoun, actualPronoun);
    }
    @Test
    public void testGetReflexivePronounForFemale() {
        String expectedPronoun = "Herself";
        String actualPronoun = pronounsGenerator.getReflexive(female);
        assertEquals(expectedPronoun, actualPronoun);
    }
}
