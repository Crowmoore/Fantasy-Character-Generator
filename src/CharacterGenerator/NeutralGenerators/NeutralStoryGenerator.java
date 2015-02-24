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
import Characters.CharacterBase;
import Story.StoryPart;
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
    
    public String generateStory(CharacterBase characterBase){//(String firstname, String lastname, int age, Gender gender, Personality personality, String city, String likes, String deity) {
        List part1 = Arrays.asList("On a DAY winter morning in YEAR NAME was born. ",
                                   "On a DAY summer day in YEAR NAME was born. ",
                                   "NAME was born during wartime in YEAR. ",
                                   "One year after EVENT2, NAME was born. ",
                                   "NAME was born during EVENT1 CITY. ",
                                   "NAME was born from the ashes of CITY. ",
                                   "NAME was born in the aftermath of EVENT1 CITY. ",
                                   "YEAR, on a night of blood moon, NAME was born. ");
        List part2 = Arrays.asList("HIS early years were uneventfull. ",
                                   "As a child HE was often PERSONALITY. ",
                                   "A single untold event in HIS childhood left HIM permanently PERSONALITY. ",
                                   "HIS love for LIKES was clear from the start. ",
                                   "HE spent HIS early years inside the walls of CITY. ",
                                   "As a child HE witnessed EVENT2. ",
                                   "When HE was little, HE read a book about ITEM. It changed HIS life. ",
                                   "As a child HE received a blessing from DEITY. ",
                                   "Even as a child HE fought ADJECTIVE. ",
                                   "As a child HE was always practising with WEAPON. ",
                                   "HE was a lonely child. ",
                                   "HE didn't know why, but HE always hated LIKES. ",
                                   "HIS father died at BATTLE. ",
                                   "HE often saw nightmares about terrible ENEMY who would steal HIS soul. ",
                                   "HE lost HIS family in EVENT1 CITY. ",
                                   "During EVENT2 HE was hiding in a empty barrel with ITEM. ",
                                   "When HE was a child HE used to argue with a PROFESSION's son about LIKES. ",
                                   "Once HE picked up ITEM and hit an unsuspecting neighbour with it. ");
        List part3 = Arrays.asList("Later HE became a formidable PROFESSION. ",
                                   "When HE grew older, HE unwillingly participated in EVENT2. ",
                                   "EVENT2 was the greatest struggle of HIS life. ",
                                   "HE died during BATTLE at the age of AGE. ",
                                   "During BATTLE HIS WEAPON broke, leaving HIM helpless on the battlefield. ",
                                   "HE was mortally wounded defending HIS liege at BATTLE. ",
                                   "HE fought ADJECTIVE at BATTLE. ",
                                   "HE got drunk before BATTLE and forgot where HE had put HIS WEAPON. ",
                                   "At one point he decided to become PROFESSION. ",
                                   "HE became a PROFESSION, but was lousy at it and decided to do something else. ",
                                   "HE spent most of HIS days drunk. ",
                                   "During BATTLE HE got overwhelmed by the ENEMY horde, but DEITY, intervened. ",
                                   "DEITY, claimed HIS soul during BATTLE. ",
                                   "At the age of AGE, HE got drunk and fell to HIS death from a cliff. ",
                                   "During BATTLE HE tripped on HIS own WEAPON. HE died instantly. ",
                                   "HE died defending HIS home CITY from ENEMY raiders. ",
                                   "When HE got older HE finally realised how much HE loved LIKES. ");
        
        String sentence1 = (String) part1.get(randomizer.getRandomNumber(part1.size()));
        String first = cleaner.cleanSentence(sentence1, characterBase);//(sentence1, firstname, lastname, age, gender, personality, city, likes, deity);
        
        String sentence2 = (String) part2.get(randomizer.getRandomNumber(part2.size()));
        String second = cleaner.cleanSentence(sentence2, characterBase);//(sentence2, firstname, lastname, age, gender, personality, city, likes, deity);
        
        String sentence3 = (String) part3.get(randomizer.getRandomNumber(part3.size()));
        String third = cleaner.cleanSentence(sentence3, characterBase);//(sentence3, firstname, lastname, age, gender, personality, city, likes, deity);
        
        String story = String.format("%s%s\n%s", first, second, third);
        return story;
    }
    
}
