/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package story;

import interfaces.ListProvider;
import interfaces.Randomizer;
import neutralGenerators.NeutralPronounsGenerator;
import character.Character;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Cleans a part of a story by replacing tags with their proper values 
 * @author Greatmelons
 */
public class StoryCleaner {
    
    NeutralPronounsGenerator pronouns = new NeutralPronounsGenerator();
    Randomizer randomizer;
    ListProvider listProvider;
    private final int year = 6500;
    /**
     * Constructor for StoryCleaner
     * @param randomizer
     * @param listProvider 
     */
    public StoryCleaner(Randomizer randomizer, ListProvider listProvider) {
        this.randomizer = randomizer;
        this.listProvider = listProvider;
    }
    /**
     * Assigns all the possible tags included in story parts and their proper replacements to a HashMap
     * @param sentence
     * @param character
     * @return String replaceTags(replacements, sentence)
     */
    public String cleanSentence(String sentence, Character character){
        
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
        List<String> likes = listProvider.getLikesDislikesList();
        List<String> horses = listProvider.getHorses();
        List<String> taverns = listProvider.getTaverns();

        Map<String,String> replacements = new HashMap<>();
        
        replacements.put("^HIS\\b", pronouns.getPossessiveAdj(character.getGender()));
        replacements.put("\\sHIS\\b", " " + pronouns.getPossessiveAdj(character.getGender()).toLowerCase());
        replacements.put("\\.\\sHIS\\b", ". " + pronouns.getPossessiveAdj(character.getGender()));
        replacements.put("^HIM\\b", pronouns.getObjective(character.getGender()));
        replacements.put("\\sHIM\\b", " " + pronouns.getObjective(character.getGender()).toLowerCase());
        replacements.put("^HE\\b", pronouns.getSubjective(character.getGender()));
        replacements.put("\\sHE\\b", " " + pronouns.getSubjective(character.getGender()).toLowerCase());
        replacements.put("\\.\\sHE\\b", ". " + pronouns.getSubjective(character.getGender()));
        replacements.put("\\bHIMSELF\\b", pronouns.getReflexive(character.getGender()).toLowerCase());
        replacements.put("\\bFULLNAME\\b", (character.getFirstname() + " " + character.getLastname()));
        replacements.put("\\bPERSONALITY\\b", character.getPersonality().getPersonalityAsText());
        replacements.put("\\bLIKES\\b", likes.get(randomizer.getRandomNumber(likes.size())));
        replacements.put("\\bCITY\\b", character.getCity());
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
        replacements.put("\\bDEITY\\b", character.getDeity());
        replacements.put("\\bTAVERN\\b", taverns.get(randomizer.getRandomNumber(taverns.size())));
        replacements.put("\\bHORSE\\b", horses.get(randomizer.getRandomNumber(horses.size())));
        replacements.put("\\bYEAR\\b", Integer.toString(year - character.getAge()));
        replacements.put("\\bAGE\\b", Integer.toString(character.getAge()));
        
        return replaceTags(replacements, sentence);

    }
    /**
     * Replaces tags from a sentence with keyvalues
     * @param tags
     * @param sentence
     * @return String sentence
     */
    private String replaceTags(Map<String,String> tags, String sentence) {
        for(String key : tags.keySet()) {
            sentence = sentence.replaceAll(key, tags.get(key));
        }
        return sentence;
    }
}
