/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Elf;

import CharacterGenerator.Interfaces.CityGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class ElfCityGenerator implements CityGenerator{
    
    List<String> elfCityList;
    Randomizer randomizer;

    public ElfCityGenerator(Randomizer randomizer, List<String> elfCities) {
        this.randomizer = randomizer;
        this.elfCityList = elfCities;
    }
    /**
     *
     * @return
     */
    @Override
    public String generateCity() {
        String city = elfCityList.get(randomizer.getRandomNumber(elfCityList.size()));
        return city;
    }
    
}
    

