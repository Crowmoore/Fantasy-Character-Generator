/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.NeutralGenerators;

import CharacterGenerator.Interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Greatmelons
 */
public class NeutralLikesGeneratorTest {
    
    Randomizer randomizer;
    NeutralLikesGenerator likesGenerator;
    List<String> likes = Arrays.asList("fish", "cotton");
    
    @Before
    public void setup(){
        randomizer = mock(Randomizer.class);
        likesGenerator = new NeutralLikesGenerator(randomizer, likes);
    }
    /**
     * Test of generateLikes method, of class NeutralLikesGenerator.
     */
    @Test
    public void testGenerateLikes() {
        
        //Arrange
        when(randomizer.getRandomNumber(likes.size())).thenReturn(1);
        String expectedLike = "cotton";
        
        //Act
        String actualLike = likesGenerator.generateLikes();
        
        //Assert
        assertEquals(expectedLike, actualLike);
        
    }
    
}
