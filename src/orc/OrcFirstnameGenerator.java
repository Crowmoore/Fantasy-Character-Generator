/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orc;

import enums.Gender;
import interfaces.FirstnameGenerator;
import interfaces.Randomizer;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class OrcFirstnameGenerator implements FirstnameGenerator{
    
    List<String> orcFirstnameListM;
    List<String> orcFirstnameListF;

    Randomizer randomizer;
    /**
     * Constructor for OrcFirstnameGenerator
     * @param randomizer
     * @param firstnamesM
     * @param firstnamesF 
     */
    public OrcFirstnameGenerator(Randomizer randomizer, List<String> firstnamesM, List<String> firstnamesF) {
        this.randomizer = randomizer;
        this.orcFirstnameListM = firstnamesM;
        this.orcFirstnameListF = firstnamesF;
    }
    /**
     * Gets a random firstname for an orc based on gender 
     * @param gender
     * @return String firstname
     */
    @Override
    public String generateFirstname(Gender gender) {
        switch(gender) {
            case MALE: return orcFirstnameListM.get(randomizer.getRandomNumber(orcFirstnameListM.size()));
            default: return orcFirstnameListF.get(randomizer.getRandomNumber(orcFirstnameListF.size()));
        }
    }
    
}
