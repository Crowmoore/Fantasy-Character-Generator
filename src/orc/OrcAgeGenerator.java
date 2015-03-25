/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orc;

import interfaces.AgeGenerator;
import interfaces.Randomizer;

/**
 *
 * @author Greatmelons
 */
public class OrcAgeGenerator implements AgeGenerator{
    
    Randomizer randomizer;

    public OrcAgeGenerator(Randomizer randomizer) {
        this.randomizer = randomizer;
    }
    /**
     *
     * @return
     */
    @Override
    public int generateAge() {
        int age = randomizer.getRandomNumber(175-25) + 25;
        return age;
    }
    
}
