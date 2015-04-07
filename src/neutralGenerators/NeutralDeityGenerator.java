/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutralGenerators;

import interfaces.DeityGenerator;
import interfaces.Randomizer;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class NeutralDeityGenerator implements DeityGenerator{
    
    List<String> deityList;    
    Randomizer randomizer;
    /**
     * Constructor for NeutrarlDeityGenerator
     * @param randomizer
     * @param deityList 
     */
    public NeutralDeityGenerator(Randomizer randomizer, List<String> deityList) {
        this.randomizer = randomizer;
        this.deityList = deityList;
    }
    /**
     * Generates a random deity for a character from deityList
     * @return String deity
     */
    @Override
    public String generateDeity() {
        String deity = deityList.get(randomizer.getRandomNumber(deityList.size()));
        return deity;
    }
    
}
