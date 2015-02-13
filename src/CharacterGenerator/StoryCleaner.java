/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator;

import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Enums.Personality;
import CharacterGenerator.Enums.Pronouns;
import CharacterGenerator.Interfaces.Randomizer;
import CharacterGenerator.NeutralGenerators.NeutralPronounsGenerator;
import CharacterGenerator.NeutralGenerators.RandomNumberGenerator;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class StoryCleaner {
    
    List<String> events1 = Arrays.asList("The Siege of", "The Great Famine of", "The Flames of", "The Exodus from", "The Rise of");
    List<String> events2 = Arrays.asList("The Reign of Bharag the Executor", "The Great Fall", "The Fall of Sek'har", "The Long Dark", "The Endless Winter");
    List<String> battles = Arrays.asList("The Battle of Styx Valley", "The Raid of Morg'or", "The Battle of Warrior's Fjord", "The Siege of Monument's Embrace");
    List<String> professions = Arrays.asList("a carpenter", "a blacksmith", "an alchemist", "a warrior", "a tinkerer", "an engineer", "a miner", "an animal trainer", "an archer");
    List<String> items = Arrays.asList("a rock", "a barrel", "a helmet", "a mining pick", "a sword", "a large book about folklore", "a boot", "an arrow", "a horseshoe", "a pickaxe");
    List<String> adjectives = Arrays.asList("valiantly", "bravely", "cowardly", "boldly", "valorously");
    List<String> weapons = Arrays.asList("sword", "greathammer", "dagger", "bow", "crossbow", "hammer", "bastard sword", "slingshot", "axe", "waraxe");
    List<String> weather = Arrays.asList("warm", "cold", "bright", "stormy", "rainy");
    
    NeutralPronounsGenerator pronouns = new NeutralPronounsGenerator();
    Randomizer randomizer;
    
    public StoryCleaner(Randomizer randomizer) {
        this.randomizer = randomizer;
    }
    
    public String cleanSentence(String sentence, String firstname, String lastname, int age, Gender gender, Personality personality, String city, String likes, String deity) {
        
        String finalSentence = sentence;
        
        finalSentence = finalSentence.replaceAll("HIS", pronouns.getPossessiveAdj(gender));
        finalSentence = finalSentence.replaceAll("HIM", pronouns.getObjective(gender));
        finalSentence = finalSentence.replaceAll("HE", pronouns.getSubjective(gender));
        finalSentence = finalSentence.replaceAll("HIMSELF", pronouns.getReflexive(gender));
        finalSentence = finalSentence.replaceAll("NAME", (firstname + " " + lastname));
        finalSentence = finalSentence.replaceAll("PERSONALITY", personality.getPersonalityAsText());
        finalSentence = finalSentence.replaceAll("LIKES", likes);
        finalSentence = finalSentence.replaceAll("CITY", city);
        finalSentence = finalSentence.replaceAll("EVENT1", events1.get(randomizer.getRandomNumber(events1.size())));
        finalSentence = finalSentence.replaceAll("EVENT2", events2.get(randomizer.getRandomNumber(events2.size())));
        finalSentence = finalSentence.replaceAll("BATTLE", battles.get(randomizer.getRandomNumber(battles.size())));
        finalSentence = finalSentence.replaceAll("ADJECTIVE", adjectives.get(randomizer.getRandomNumber(adjectives.size())));
        finalSentence = finalSentence.replaceAll("PROFESSION", professions.get(randomizer.getRandomNumber(professions.size())));
        finalSentence = finalSentence.replaceAll("WEAPON", weapons.get(randomizer.getRandomNumber(weapons.size())));
        finalSentence = finalSentence.replaceAll("DAY", weather.get(randomizer.getRandomNumber(weather.size())));
        finalSentence = finalSentence.replaceAll("ITEM", items.get(randomizer.getRandomNumber(items.size())));
        finalSentence = finalSentence.replaceAll("DEITY", deity);
        finalSentence = finalSentence.replaceAll("YEAR", Integer.toString(1850 - age));
        finalSentence = finalSentence.replaceAll("AGE", Integer.toString(age));
    
        return finalSentence;

    }
}
