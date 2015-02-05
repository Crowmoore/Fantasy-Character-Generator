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
    
    List<String> elfCityList = Arrays.asList("Amyenshys", "Shylve Entheas", "Emflin", "Amyfrion", "Mfe Asari", "Ellon", "Ins Lenora", "Emi Alora", "Onle Taesi", "Wailin", "Efan Esari");
    Randomizer randomizer;

    public ElfCityGenerator(Randomizer randomizer) {
        this.randomizer = randomizer;
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
    

