/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwarf;

import interfaces.LastnameGenerator;
import interfaces.Randomizer;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class DwarfLastnameGenerator implements LastnameGenerator {
    
    List<String> dwarfLastnamePrefixList;
    List<String> dwarfLastnameSuffixList;

    Randomizer randomizer;
    
    /**
     * Constructor for DwarfLastnameGenerator
     * @param randomizer
     * @param prefix
     * @param suffix 
     */
    public DwarfLastnameGenerator(Randomizer randomizer, List<String> prefix, List<String> suffix) {
        this.randomizer = randomizer;
        this.dwarfLastnamePrefixList = prefix;
        this.dwarfLastnameSuffixList = suffix;
    }

    /**
     * Generates a lastname for a dwarf by combining prefix and suffix
     * @return String lastname
     */
    @Override
    public String generateLastname() {
        
        String lastnamePre = dwarfLastnamePrefixList.get(randomizer.getRandomNumber(dwarfLastnamePrefixList.size()));
        String lastnameSuf = dwarfLastnameSuffixList.get(randomizer.getRandomNumber(dwarfLastnameSuffixList.size()));
        return lastnamePre + lastnameSuf;
    }
}
