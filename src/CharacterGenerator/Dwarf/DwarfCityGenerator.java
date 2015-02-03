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
public class DwarfCityGenerator implements CityGenerator, Randomizer{
    
    List<String> dwarfCityList = Arrays.asList("Gorndarum", "Birnkahldur", "Hig Faldir", "Bhom Buldor", "Haggrim", "Dugbihr", "Gol Durahl", "Bhogh Darohm", "Thoghbuldahr", "Veglodahr", "Kan Taruhm", "Ham Darul", "Vern Darim");
    
    /**
     *
     * @return
     */
    @Override
    public String generateCity() {
        String city = dwarfCityList.get(randomizer.nextInt(dwarfCityList.size()));
        return city;
    }
    
}
