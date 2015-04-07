/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elf;

import interfaces.AgeGenerator;
import interfaces.Randomizer;

/**
 *
 * @author Greatmelons
 */
public class ElfAgeGenerator implements AgeGenerator {

    Randomizer randomizer;

    /**
     * Constructor for ElfAgeGenerator
     * @param randomizer 
     */
    public ElfAgeGenerator(Randomizer randomizer) {
        this.randomizer = randomizer;
    }
    /**
     * Gets a random age between 25 and 5000 years for elf
     * @return int age
     */
    @Override
    public int generateAge() {
        int age = randomizer.getRandomNumber(5000 - 25) + 25;
        return age;
    }
    
}
