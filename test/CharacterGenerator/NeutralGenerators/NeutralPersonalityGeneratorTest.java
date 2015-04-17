/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.NeutralGenerators;

import neutralGenerators.NeutralPersonalityGenerator;
import enums.Personality;
import interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Greatmelons
 */
public class NeutralPersonalityGeneratorTest {
    
    Randomizer randomizer;
    NeutralPersonalityGenerator personalityGenerator;
    List<Personality> personalities = Arrays.asList(Personality.values());
    
    @Before
    public void setup() {
        randomizer = mock(Randomizer.class);
        personalityGenerator = new NeutralPersonalityGenerator(randomizer, personalities);        
    }
    @Test
    public void testGeneratePersonality() {
        //Arrange
        when(randomizer.getRandomNumber(personalities.size())).thenReturn(1);
        Personality expectedPersonality = Personality.AGGRESSIVE;
        //Act
        Personality actualPersonality = personalityGenerator.generatePersonality();
        //Assert
        assertEquals(expectedPersonality, actualPersonality);
    }
    
}
