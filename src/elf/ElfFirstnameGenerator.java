/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elf;

import enums.Gender;
import interfaces.FirstnameGenerator;
import interfaces.Randomizer;
import java.util.List;

/**
 * Generates a random first name for an elf
 * @author Greatmelons
 */
public class ElfFirstnameGenerator implements FirstnameGenerator{
    
    List<String> elfFirstnameListM;
    List<String> elfFirstnameListF;
    Randomizer randomizer;
    
    /**
     * Constructor for ElfFirstnameGenerator
     * @param randomizer
     * @param maleNames
     * @param femaleNames 
     */
    public ElfFirstnameGenerator(Randomizer randomizer, List<String> maleNames, List<String> femaleNames) {
        this.randomizer = randomizer;
        this.elfFirstnameListF = femaleNames;
        this.elfFirstnameListM = maleNames;
    }
    /**
     * Gets a random first name for an elf based on gender
     * @param gender
     * @return String
     */
    @Override
    public String generateFirstname(Gender gender) {
        switch(gender) {
            case MALE: return elfFirstnameListM.get(randomizer.getRandomNumber(elfFirstnameListM.size()));
            default: return elfFirstnameListF.get(randomizer.getRandomNumber(elfFirstnameListF.size()));
        }
    }
    
}
