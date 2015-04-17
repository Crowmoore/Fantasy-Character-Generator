/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orc;

import interfaces.LastnameGenerator;
import interfaces.Randomizer;
import java.util.List;

/**
 * Generates a random last name for an orc
 * @author Greatmelons
 */
public class OrcLastnameGenerator implements LastnameGenerator {
    
    List<String> orcLastnamePrefixList;
    List<String> orcLastnameSuffixList;

    Randomizer randomizer;
    /**
     * Constructor for OrcLastnameGenerator
     * @param randomizer
     * @param prefix
     * @param suffix 
     */
    public OrcLastnameGenerator(Randomizer randomizer, List<String> prefix, List<String> suffix) {
        this.randomizer = randomizer;
        this.orcLastnamePrefixList = prefix;
        this.orcLastnameSuffixList = suffix;
    }
    /**
     * Generates a random last name for an orc by combining a prefix and a suffix
     * @return String lastnamePre + lastnameSuf;
     */
    @Override
    public String generateLastname() {
        
        String lastnamePre = orcLastnamePrefixList.get(randomizer.getRandomNumber(orcLastnamePrefixList.size()));
        String lastnameSuf = orcLastnameSuffixList.get(randomizer.getRandomNumber(orcLastnameSuffixList.size()));
        return lastnamePre + lastnameSuf;
    }
    
}
