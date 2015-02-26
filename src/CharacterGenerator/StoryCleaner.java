/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator;

import CharacterGenerator.Interfaces.ListProvider;
import CharacterGenerator.Interfaces.Randomizer;
import CharacterGenerator.NeutralGenerators.NeutralPronounsGenerator;
import Characters.CharacterBase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Greatmelons
 */
public class StoryCleaner {
    
    NeutralPronounsGenerator pronouns = new NeutralPronounsGenerator();
    Randomizer randomizer;
    ListProvider listProvider;
    private int year = 6500;
    
    public StoryCleaner(Randomizer randomizer, ListProvider listProvider) {
        this.randomizer = randomizer;
        this.listProvider = listProvider;
    }
    
    public String cleanSentence(String sentence, CharacterBase characterBase){
        
        List<String> events1 = listProvider.getEvents1();
        List<String> events2 = listProvider.getEvents2();
        List<String> battles = listProvider.getBattles();
        List<String> professions = listProvider.getProfessions();
        List<String> items = listProvider.getItems();
        List<String> adjectives = listProvider.getAdjectives();
        List<String> weapons = listProvider.getWeapons();
        List<String> weather = listProvider.getWeather();
        List<String> enemies = listProvider.getEnemies();
        List<String> seasons = listProvider.getSeasons();
        List<String> diseases = listProvider.getDiseases();
        List<String> movementVerbs = listProvider.getMovementVerbs();
        List<String> oralVerbs = listProvider.getOralVerbs();
        
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
