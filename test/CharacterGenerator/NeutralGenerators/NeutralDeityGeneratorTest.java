/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.NeutralGenerators;

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
public class NeutralDeityGeneratorTest {
    
    Randomizer randomizer;
    NeutralDeityGenerator deityGenerator;
    List<String> deities = Arrays.asList("First God", "Second God");
    
    @Before
    public void setup() {
        randomizer = mock(Randomizer.class);
        deityGenerator = new NeutralDeityGenerator(randomizer, deities);
    }
    @Test
    public void testGenerateDeity() {
        //Arrange
        when(randomizer.getRandomNumber(deities.size())).thenReturn(1);
        String expectedDeity = "Second God";
        //Act
        String actualDeity = deityGenerator.generateDeity();
        //Assert
        assertEquals(expectedDeity, actualDeity);
    }

}
