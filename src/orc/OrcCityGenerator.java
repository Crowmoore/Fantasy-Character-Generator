/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orc;

import interfaces.CityGenerator;
import interfaces.Randomizer;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class OrcCityGenerator implements CityGenerator{
    
    List<String> orcCityList;
    Randomizer randomizer;

    public OrcCityGenerator(Randomizer randomizer, List<String> cityList) {
        this.randomizer = randomizer;
        this.orcCityList = cityList;
    }
    /**
     *
     * @return
     */
    @Override
    public String generateCity() {
        String city = orcCityList.get(randomizer.getRandomNumber(orcCityList.size()));
        return city;
    }
    
}