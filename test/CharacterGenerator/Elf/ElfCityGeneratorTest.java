/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Elf;

import elf.ElfCityGenerator;
import interfaces.Randomizer;
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
public class ElfCityGeneratorTest {
    
    Randomizer randomizer;
    ElfCityGenerator cityGenerator;
    List<String> cities = Arrays.asList("Helsinki", "Oslo");
    
    @Before
    public void setup() {
        randomizer = mock(Randomizer.class);
        cityGenerator = new ElfCityGenerator(randomizer, cities);
    }
    @Test
    public void testGenerateCity() {
        //Arrange
        when(randomizer.getRandomNumber(cities.size())).thenReturn(1);
        String expectedCity = "Oslo";
        //Act
        String actualCity = cityGenerator.generateCity();
        //Assert
        assertEquals(expectedCity, actualCity);
    }
}
