/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Dwarf;

import CharacterGenerator.Interfaces.CityGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class DwarfCityGenerator implements CityGenerator {
    
    List<String> dwarfCityList = Arrays.asList("Gorndarum", "Birnkahldur", "Hig Faldir", "Bhom Buldor", "Haggrim", "Dugbihr", "Gol Durahl", "Bhogh Darohm", "Thoghbuldahr", "Veglodahr", "Kan Taruhm", "Ham Darul", "Vern Darim");

    Randomizer randomizer;

    public DwarfCityGenerator(Randomizer randomizer) {
        this.randomizer = randomizer;
    }
    /**
     *
     * @return
     */
    @Override
    public String generateCity() {
        String city = dwarfCityList.get(randomizer.getRandomNumber(dwarfCityList.size()));
        return city;
    }
    
}
