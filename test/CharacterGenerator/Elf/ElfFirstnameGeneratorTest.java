/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Elf;

import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author Greatmelons
 */
public class ElfFirstnameGeneratorTest {
    
    Randomizer randomizer;
    Gender male;
    Gender female;
    int sizeOfBothLists;
    ElfFirstnameGenerator firstnameGenerator;
    List<String> maleNames = Arrays.asList("Harry", "Robert");
    List<String> femaleNames = Arrays.asList("Heidi", "Amanda");

    @Before
    public void setup() {
        randomizer = mock(Randomizer.class);
        firstnameGenerator = new ElfFirstnameGenerator(randomizer, maleNames, femaleNames);
        sizeOfBothLists = 2;
        male = Gender.MALE;
        female = Gender.FEMALE;
    }
    @Test
    public void testGenerateNameForMale() {
        when(randomizer.getRandomNumber(sizeOfBothLists)).thenReturn(1);
        String expectedName = "Robert";
        String actualName = firstnameGenerator.generateFirstname(male);
        assertEquals(expectedName, actualName);
    }
    @Test
    public void testGenerateNameForFemale() {
        when(randomizer.getRandomNumber(sizeOfBothLists)).thenReturn(1);
        String expectedName = "Amanda";
        String actualName = firstnameGenerator.generateFirstname(female);
        assertEquals(expectedName, actualName);
    }
}
