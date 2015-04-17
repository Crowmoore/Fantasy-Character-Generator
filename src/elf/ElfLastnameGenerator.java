/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elf;

import interfaces.LastnameGenerator;
import interfaces.Randomizer;

import java.util.List;

/**
 * Generates a random last name for an elf
 * @author Greatmelons
 */
public class ElfLastnameGenerator implements LastnameGenerator {
    
    List<String> elfLastnameList;

    Randomizer randomizer;

    /**
     * Constructor for ElfLastNameGenerator
     * @param randomizer
     * @param lastnameList 
     */
    public ElfLastnameGenerator(Randomizer randomizer, List<String> lastnameList) {
        this.randomizer = randomizer;
        this.elfLastnameList = lastnameList;
    }
    /**
     * Gets a random last name for an elf from elfLastnameList
     * @return String lastname
     */
    @Override
    public String generateLastname() {
        
        String lastname = elfLastnameList.get(randomizer.getRandomNumber(elfLastnameList.size()));
        return lastname;
    }
}
