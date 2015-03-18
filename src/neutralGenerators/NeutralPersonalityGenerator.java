/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutralGenerators;

import enums.Personality;
import interfaces.PersonalityGenerator;
import interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class NeutralPersonalityGenerator implements PersonalityGenerator{
    
    List<Personality> personalities;
    Randomizer randomizer;
    
    public NeutralPersonalityGenerator(Randomizer randomizer, List<Personality> personalities) {
        this.randomizer = randomizer;
        this.personalities = personalities;
    }

    /**
     *
     * @return
     */
    @Override
    public Personality generatePersonality() {        
        
        Personality personality = personalities.get(randomizer.getRandomNumber(personalities.size()));
        return personality;
    }
    
}
