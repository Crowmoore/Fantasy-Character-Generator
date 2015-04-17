/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Elf;

import elf.ElfLastnameGenerator;
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
public class ElfLastnameGeneratorTest {
    
    Randomizer randomizer;
    ElfLastnameGenerator lastnameGenerator;
    List<String> lastNames = Arrays.asList("Treehugger", "Pointyears");
    
    @Before
    public void setup() {
        randomizer = mock(Randomizer.class);
        lastnameGenerator = new ElfLastnameGenerator(randomizer, lastNames);
    }
    @Test
    public void testGenerateLastname() {
        when(randomizer.getRandomNumber(lastNames.size())).thenReturn(1);
        String expectedName = "Pointyears";
        String actualName = lastnameGenerator.generateLastname();
        assertEquals(expectedName, actualName);
    }
}
