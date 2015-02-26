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
import Characters.CharacterBase;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.*;

/**
 *
 * @author Greatmelons
 */
public class StoryCleaner {
    
    NeutralPronounsGenerator pronouns = new NeutralPronounsGenerator();
    Randomizer randomizer;
    private int year = 6500;
    
    public StoryCleaner(Randomizer randomizer) {
        this.randomizer = randomizer;
    }
    
    public String cleanSentence(String sentence, CharacterBase characterBase){
        
        ListReader reader = new ListReader();
        List<String> events1 = reader.readFromFile("lists/story/events1.txt");
        List<String> events2 = reader.readFromFile("lists/story/events2.txt");
        List<String> battles = reader.readFromFile("lists/story/battles.txt");
        List<String> professions = reader.readFromFile("lists/story/professions.txt");
        List<String> items = reader.readFromFile("lists/story/items.txt");
        List<String> adjectives = reader.readFromFile("lists/story/adjectives.txt");
        List<String> weapons = reader.readFromFile("lists/story/weapons.txt");
        List<String> weather = reader.readFromFile("lists/story/weather.txt");
        List<String> enemies = reader.readFromFile("lists/story/enemies.txt");
        List<String> seasons = reader.readFromFile("lists/story/seasons.txt");
        List<String> diseases = reader.readFromFile("lists/story/diseases.txt");
        List<String> movementVerbs = reader.readFromFile("lists/story/movementVerbs.txt");
        List<String> oralVerbs = reader.readFromFile("lists/story/oralVerbs.txt");
        
        String finalSentence = sentence;
        Map<String,String> replacements = new HashMap<>();
        
        replacements.put("HIS", pronouns.getPossessiveAdj(characterBase.getGender()));
        replacements.put("HIM", pronouns.getObjective(characterBase.getGender()));
        replacements.put("HE", pronouns.getSubjective(characterBase.getGender()));
        replacements.put("HIMSELF", pronouns.getReflexive(characterBase.getGender()));
        replacements.put("FULLNAME", (characterBase.getFirstname() + " " + characterBase.getLastname()));
        replacements.put("PERSONALITY", characterBase.getPersonality().getPersonalityAsText());
        replacements.put("LIKES", characterBase.getLikes());
        replacements.put("CITY", characterBase.getCity());
        replacements.put("SEASON", seasons.get(randomizer.getRandomNumber(seasons.size())));
        replacements.put("DISEASE", diseases.get(randomizer.getRandomNumber(diseases.size())));
        replacements.put("EVENT1", events1.get(randomizer.getRandomNumber(events1.size())));
        replacements.put("EVENT2", events2.get(randomizer.getRandomNumber(events2.size())));
        replacements.put("BATTLE", battles.get(randomizer.getRandomNumber(battles.size())));
        replacements.put("ADJECTIVE", adjectives.get(randomizer.getRandomNumber(adjectives.size())));
        replacements.put("PROFESSION", professions.get(randomizer.getRandomNumber(professions.size())));
        replacements.put("WEAPON", weapons.get(randomizer.getRandomNumber(weapons.size())));
        replacements.put("DAY", weather.get(randomizer.getRandomNumber(weather.size())));
        replacements.put("ITEM", items.get(randomizer.getRandomNumber(items.size())));
        replacements.put("ENEMY", enemies.get(randomizer.getRandomNumber(enemies.size())));
        replacements.put("MOVEMENTVERB", movementVerbs.get(randomizer.getRandomNumber(movementVerbs.size())));
        replacements.put("ORALVERB", oralVerbs.get(randomizer.getRandomNumber(oralVerbs.size())));
        replacements.put("DEITY", characterBase.getDeity());
        replacements.put("YEAR", Integer.toString(year - characterBase.getAge()));
        replacements.put("AGE", Integer.toString(characterBase.getAge()));
        
        return replaceTags(replacements, sentence);

    }
    private String replaceTags(Map<String,String> tags, String sentence) {
        for(String key : tags.keySet()) {
            sentence = sentence.replaceAll(key, tags.get(key));
        }
        return sentence;
    }
}
