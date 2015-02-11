/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.NeutralGenerators;

import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Enums.Personality;
import CharacterGenerator.Interfaces.Randomizer;
import CharacterGenerator.Interfaces.StoryGenerator;
import CharacterGenerator.StoryCleaner;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class NeutralStoryGenerator implements StoryGenerator{
    
    Randomizer randomizer;
    StoryCleaner cleaner;
    
    public NeutralStoryGenerator(Randomizer randomizer, StoryCleaner cleaner) {
        this.randomizer = randomizer;
        this.cleaner = cleaner;
    }
    
    public String generateStory(String firstname, String lastname, int age, Gender gender, Personality personality, String city, String likes, String deity) {
        List part1 = Arrays.asList("On a cold winter morning in YEAR NAME was born. ",
                                   "On a hot summer day in YEAR NAME was born. ",
                                   "NAME was born during wartime in YEAR. ",
                                   "One year after EVENT2, NAME was born. ",
                                   "NAME was born during EVENT1 CITY. ",
                                   "YEAR, on a night of blood moon, NAME was born. ");
        List part2 = Arrays.asList("HIS early years were uneventfull. ",
                                   "As a child HE was usually PERSONALITY. ",
                                   "HIS love for LIKES was clear from the start. ",
                                   "HE spent HIS early years inside the walls of CITY. ",
                                   "As a child HE witnessed EVENT2. ",
                                   "As a child HE received a blessing from DEITY. ",
                                   "HE was a lonely child. ",
                                   "HIS father died at BATTLE. ",
                                   "HE lost HIS family in EVENT1 CITY. ",
                                   "During EVENT2 HE was hiding in a empty barrel of ale with ITEM. ",
                                   "When HE was a child HE used to argue with PROFESSION's son about LIKES. ",
                                   "Once HE picked up ITEM and hit an unsuspecting neighbour with it. ");
        List part3 = Arrays.asList("Later HE became a formidable PROFESSION. ",
                                   "When HE grew older, HE unwillingly participated in EVENT2. ",
                                   "EVENT2 was the greatest struggle of HIS life. ",
                                   "HE died during BATTLE at the age of AGE. ",
                                   "HE was mortally wounded defending his liege at BATTLE. ",
                                   "HE fought valiantly at BATTLE. ",
                                   "At one point he decided to become PROFESSION. ",
                                   "HE became PROFESSION, but was lousy at it and decided to do something else. ",
                                   "HE spent most of HIS days drunk. ",
                                   "During BATTLE HE tripped on HIS own weapon. HE died instantly. ",
                                   "When HE got older HE finally realised how much HE loved LIKES. ");
        
        String sentence1 = (String) part1.get(randomizer.getRandomNumber(part1.size()));
        String first = cleaner.cleanSentence(sentence1, firstname, lastname, age, gender, personality, city, likes, deity);
        
        String sentence2 = (String) part2.get(randomizer.getRandomNumber(part2.size()));
        String second = cleaner.cleanSentence(sentence2, firstname, lastname, age, gender, personality, city, likes, deity);
        
        String sentence3 = (String) part3.get(randomizer.getRandomNumber(part3.size()));
        String third = cleaner.cleanSentence(sentence3, firstname, lastname, age, gender, personality, city, likes, deity);
        
        String story = String.format("%s%s\n%s", first, second, third);
        return story;
    }
    
}
