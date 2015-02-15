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
    
    List<String> deityList = Arrays.asList("Cuvther, The Goddess of Fertility", "Mueyr, The God of Ale", "Qoldur, The God of Poetry", "Juxorr, The Goddess of Mercy", "Durlo, The God of Good Luck", "Kidorr, The God of Earth", "Nutdon, The God of Fire", "Wyeyar, The God of Night", "Emaos, The God of the Underworld", "Jidite, The God of Revenge");
    
    Randomizer randomizer;

    public NeutralDeityGenerator(Randomizer randomizer) {
        this.randomizer = randomizer;
    }
    public String generateDeity() {
        String deity = deityList.get(randomizer.getRandomNumber(deityList.size()));
        return deity;
    }
    
}
