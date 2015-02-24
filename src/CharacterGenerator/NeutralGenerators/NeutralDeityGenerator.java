/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.NeutralGenerators;

import CharacterGenerator.Interfaces.DeityGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class NeutralDeityGenerator implements DeityGenerator{
    
    List<String> deityList;
    
    Randomizer randomizer;

    public NeutralDeityGenerator(Randomizer randomizer, List<String> deityList) {
        this.randomizer = randomizer;
        this.deityList = deityList;
    }
    public String generateDeity() {
        String deity = deityList.get(randomizer.getRandomNumber(deityList.size()));
        return deity;
    }
    
}
