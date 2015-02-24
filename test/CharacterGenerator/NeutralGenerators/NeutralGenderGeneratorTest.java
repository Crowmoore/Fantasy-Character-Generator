/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.NeutralGenerators;

import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Interfaces.GenderGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author Greatmelons
 */
public class NeutralGenderGeneratorTest {
    
    Randomizer randomizer;
    NeutralGenderGenerator genderGenerator;
    List<Gender> genders = Arrays.asList(Gender.values());
    
    @Before
    public void setup() {
        randomizer = mock(Randomizer.class);
        genderGenerator = new NeutralGenderGenerator(randomizer, genders);
    }
    @Test
    public void testGenerateGender() {
        //Arrange
        when(randomizer.getRandomNumber(genders.size())).thenReturn(1);
        Gender expectedGender = Gender.FEMALE;
        //Act
        Gender actualGender = genderGenerator.generateGender();
        //Assert
        assertEquals(expectedGender, actualGender);
    }
    
}
