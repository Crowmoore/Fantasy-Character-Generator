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
 * Generates a random last name for a dwarf
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
     * Generates a last name for a dwarf by combining a prefix and a suffix
     * @return String lastnamePre + lastnameSuf
     */
    @Override
    public String generateLastname() {
        
        String lastnamePre = dwarfLastnamePrefixList.get(randomizer.getRandomNumber(dwarfLastnamePrefixList.size()));
        String lastnameSuf = dwarfLastnameSuffixList.get(randomizer.getRandomNumber(dwarfLastnameSuffixList.size()));
        return lastnamePre + lastnameSuf;
    }
}
