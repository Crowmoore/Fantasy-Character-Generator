/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orc;

import interfaces.AgeGenerator;
import interfaces.Randomizer;

/**
 * Generates a random age for an orc
 * @author Greatmelons
 */
public class OrcAgeGenerator implements AgeGenerator{
    
    Randomizer randomizer;
    
    /**
     * Constructor for OrcAgeGenerator
     * @param randomizer 
     */
    public OrcAgeGenerator(Randomizer randomizer) {
        this.randomizer = randomizer;
    }
    /**
     * Gets a random age between 25 and 175 years
     * @return int age
     */
    @Override
    public int generateAge() {
        int age = randomizer.getRandomNumber(175-25) + 25;
        return age;
    }
    
}
