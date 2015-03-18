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

    public ElfAgeGenerator(Randomizer randomizer) {
        this.randomizer = randomizer;
    }
    /**
     *
     * @return
     */
    @Override
    public int generateAge() {
        int age = randomizer.getRandomNumber(5000 - 25) + 25;
        return age;
    }
    
}
