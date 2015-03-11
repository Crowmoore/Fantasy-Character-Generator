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

        Map<String,String> replacements = new HashMap<>();
        
        replacements.put("^HIS\\b", pronouns.getPossessiveAdj(characterBase.getGender()));
        replacements.put("\\sHIS\\b", " " + pronouns.getPossessiveAdj(characterBase.getGender()).toLowerCase());
        replacements.put("\\.\\sHIS\\b", ". " + pronouns.getPossessiveAdj(characterBase.getGender()));
        replacements.put("^HIM\\b", pronouns.getObjective(characterBase.getGender()));
        replacements.put("\\sHIM\\b", " " + pronouns.getObjective(characterBase.getGender()).toLowerCase());
        replacements.put("\\.\\sHIM\\b", ". " + pronouns.getObjective(characterBase.getGender()));
        replacements.put("^HE\\b", pronouns.getSubjective(characterBase.getGender()));
        replacements.put("\\sHE\\b", " " + pronouns.getSubjective(characterBase.getGender()).toLowerCase());
        replacements.put("\\.\\sHE\\b", ". " + pronouns.getSubjective(characterBase.getGender()));
        replacements.put("\\bHIMSELF\\b", pronouns.getReflexive(characterBase.getGender()).toLowerCase());
        replacements.put("\\bFULLNAME\\b", (characterBase.getFirstname() + " " + characterBase.getLastname()));
        replacements.put("\\bPERSONALITY\\b", characterBase.getPersonality().getPersonalityAsText());
        replacements.put("\\bLIKES\\b", characterBase.getLikes());
        replacements.put("\\bCITY\\b", characterBase.getCity());
        replacements.put("\\bSEASON\\b", seasons.get(randomizer.getRandomNumber(seasons.size())));
        replacements.put("\\bDISEASE\\b", diseases.get(randomizer.getRandomNumber(diseases.size())));
        replacements.put("\\bEVENT1\\b", events1.get(randomizer.getRandomNumber(events1.size())));
        replacements.put("\\bEVENT2\\b", events2.get(randomizer.getRandomNumber(events2.size())));
        replacements.put("\\bBATTLE\\b", battles.get(randomizer.getRandomNumber(battles.size())));
        replacements.put("\\bADJECTIVE\\b", adjectives.get(randomizer.getRandomNumber(adjectives.size())));
        replacements.put("\\bPROFESSION", professions.get(randomizer.getRandomNumber(professions.size())));
        replacements.put("\\bWEAPON", weapons.get(randomizer.getRandomNumber(weapons.size())));
        replacements.put("\\bWEATHER\\b", weather.get(randomizer.getRandomNumber(weather.size())));
        replacements.put("\\bITEM\\b", items.get(randomizer.getRandomNumber(items.size())));
        replacements.put("\\bENEMY\\b", enemies.get(randomizer.getRandomNumber(enemies.size())));
        replacements.put("\\bMOVEMENTVERB\\b", movementVerbs.get(randomizer.getRandomNumber(movementVerbs.size())));
        replacements.put("\\bORALVERB\\b", oralVerbs.get(randomizer.getRandomNumber(oralVerbs.size())));
        replacements.put("\\bDEITY\\b", characterBase.getDeity());
        replacements.put("\\bYEAR\\b", Integer.toString(year - characterBase.getAge()));
        replacements.put("\\bAGE\\b", Integer.toString(characterBase.getAge()));
        
        return replaceTags(replacements, sentence);

    }
    private String replaceTags(Map<String,String> tags, String sentence) {
        for(String key : tags.keySet()) {
            sentence = sentence.replaceAll(key, tags.get(key));
        }
        return sentence;
    }
}
