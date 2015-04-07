/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elf;

import interfaces.CityGenerator;
import interfaces.Randomizer;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class ElfCityGenerator implements CityGenerator{
    
    List<String> elfCityList;
    Randomizer randomizer;

    /**
     * Constructor for ElfCityGenerator
     * @param randomizer
     * @param elfCities 
     */
    public ElfCityGenerator(Randomizer randomizer, List<String> elfCities) {
        this.randomizer = randomizer;
        this.elfCityList = elfCities;
    }
    /**
     * Gets a random city from elfCityList
     * @return String city
     */
    @Override
    public String generateCity() {
        String city = elfCityList.get(randomizer.getRandomNumber(elfCityList.size()));
        return city;
    }
    
}
    

