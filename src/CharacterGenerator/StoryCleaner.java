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
import java.util.List;
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
        
        finalSentence = finalSentence.replaceAll("HIS", pronouns.getPossessiveAdj(characterBase.getGender()));
        finalSentence = finalSentence.replaceAll("HIM", pronouns.getObjective(characterBase.getGender()));
        finalSentence = finalSentence.replaceAll("HE", pronouns.getSubjective(characterBase.getGender()));
        finalSentence = finalSentence.replaceAll("HIMSELF", pronouns.getReflexive(characterBase.getGender()));
        finalSentence = finalSentence.replaceAll("FULLNAME", (characterBase.getFirstname() + " " + characterBase.getLastname()));
        finalSentence = finalSentence.replaceAll("PERSONALITY", characterBase.getPersonality().getPersonalityAsText());
        finalSentence = finalSentence.replaceAll("LIKES", characterBase.getLikes());
        finalSentence = finalSentence.replaceAll("CITY", characterBase.getCity());
        finalSentence = finalSentence.replaceAll("SEASON", seasons.get(randomizer.getRandomNumber(seasons.size())));
        finalSentence = finalSentence.replaceAll("DISEASE", diseases.get(randomizer.getRandomNumber(diseases.size())));
        finalSentence = finalSentence.replaceAll("EVENT1", events1.get(randomizer.getRandomNumber(events1.size())));
        finalSentence = finalSentence.replaceAll("EVENT2", events2.get(randomizer.getRandomNumber(events2.size())));
        finalSentence = finalSentence.replaceAll("BATTLE", battles.get(randomizer.getRandomNumber(battles.size())));
        finalSentence = finalSentence.replaceAll("ADJECTIVE", adjectives.get(randomizer.getRandomNumber(adjectives.size())));
        finalSentence = finalSentence.replaceAll("PROFESSION", professions.get(randomizer.getRandomNumber(professions.size())));
        finalSentence = finalSentence.replaceAll("WEAPON", weapons.get(randomizer.getRandomNumber(weapons.size())));
        finalSentence = finalSentence.replaceAll("DAY", weather.get(randomizer.getRandomNumber(weather.size())));
        finalSentence = finalSentence.replaceAll("ITEM", items.get(randomizer.getRandomNumber(items.size())));
        finalSentence = finalSentence.replaceAll("ENEMY", enemies.get(randomizer.getRandomNumber(enemies.size())));
        finalSentence = finalSentence.replaceAll("MOVEMENTVERB", movementVerbs.get(randomizer.getRandomNumber(movementVerbs.size())));
        finalSentence = finalSentence.replaceAll("ORALVERB", oralVerbs.get(randomizer.getRandomNumber(oralVerbs.size())));
        finalSentence = finalSentence.replaceAll("DEITY", characterBase.getDeity());
        finalSentence = finalSentence.replaceAll("YEAR", Integer.toString(year - characterBase.getAge()));
        finalSentence = finalSentence.replaceAll("AGE", Integer.toString(characterBase.getAge()));
    
        return finalSentence;

    }
}
