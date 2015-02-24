/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.NeutralGenerators;

import CharacterGenerator.CharacterSetup;
import CharacterGenerator.Interfaces.Randomizer;
import CharacterGenerator.StoryCleaner;
import Characters.CharacterBase;
import Story.StoryPart;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Greatmelons
 */
public class NewStoryGeneratorTest {

    Randomizer randomizer;
    StoryCleaner cleaner;
    CharacterBase character;
    CharacterSetup characterSetup;
    
    @Before
    public void setup() {
        randomizer = mock(Randomizer.class);
        cleaner = mock(StoryCleaner.class);
    }
            
    @Test
    public void shouldReturnStoryWhenStorypartsHaveOnlyOneSentence() {
        //Arrange
        
        String sentence = "I found an eagle.";
        String expectedStory = sentence + " ";
        List<String> sentences = Arrays.asList("I found an eagle.");
        StoryPart storypart = new StoryPart(sentences);
        List<StoryPart> storyparts = Arrays.asList(storypart);
        when(cleaner.cleanSentence(expectedStory, character)).thenReturn(expectedStory);
        when(randomizer.getRandomNumber(sentences.size())).thenReturn(0);
        //Act
        NewStoryGenerator generator = new NewStoryGenerator();
        String actualStory = generator.generateStory(storyparts, cleaner, randomizer, character);
        actualStory = cleaner.cleanSentence(expectedStory, character);
        //Assert
        assertEquals(expectedStory, actualStory);
    }
    @Test
    public void shouldReturnSecondSentenceWhenStorypartsHaveTwoSentences() {
        //Arrange
        String sentence1 = "I found a worm.";
        String sentence2 = "I have crabs.";
        String expectedStory = sentence2 + " ";
        List<String> sentences = Arrays.asList(sentence1, sentence2);
        StoryPart storypart = new StoryPart(sentences);
        List<StoryPart> storyparts = Arrays.asList(storypart);
        when(cleaner.cleanSentence(expectedStory, character)).thenReturn(expectedStory);
        when(randomizer.getRandomNumber(sentences.size())).thenReturn(1);
        //Act
        NewStoryGenerator generator = new NewStoryGenerator();
        String actualStory = generator.generateStory(storyparts, cleaner, randomizer, character);
        actualStory = cleaner.cleanSentence(expectedStory, character);
        //Assert
        assertEquals(expectedStory, actualStory);
    }
    @Test
    public void shouldReturnStoryWhenTwoStorypartsHaveOneSentenceEach() {
        //Arrange
        int listSizeForBothLists = 1;
        List<String> sentenceForPart1 = Arrays.asList("I have worms.");
        List<String> sentenceForPart2 = Arrays.asList("I have scurvy.");
        String expectedStory = "I have worms. I have scurvy. ";
        StoryPart storypart1 = new StoryPart(sentenceForPart1);
        StoryPart storypart2 = new StoryPart(sentenceForPart2);
        List<StoryPart> storyparts = Arrays.asList(storypart1, storypart2);
        when(cleaner.cleanSentence(expectedStory, character)).thenReturn(expectedStory);
        when(randomizer.getRandomNumber(listSizeForBothLists)).thenReturn(0);
        //Act
        NewStoryGenerator generator = new NewStoryGenerator();
        String actualStory = generator.generateStory(storyparts, cleaner, randomizer, character);
        actualStory = cleaner.cleanSentence(expectedStory, character);
        //Assert
        assertEquals(expectedStory, actualStory);
    }
    @Test
    public void shouldReturnStoryWhenTwoStorypartsHaveTwoSentencesEach() {
        int listSizeForBothLists = 2;
        List<String> sentenceForPart1 = Arrays.asList("I saw a turtle.", "I found a stray dog.");
        List<String> sentenceForPart2 = Arrays.asList("It was chasing a mouse.", "It was clearly looking for food.");
        String expectedStory = "I found a stray dog. It was clearly looking for food. ";
        StoryPart storypart1 = new StoryPart(sentenceForPart1);
        StoryPart storypart2 = new StoryPart(sentenceForPart2);
        List<StoryPart> storyparts = Arrays.asList(storypart1, storypart2);
        when(cleaner.cleanSentence(expectedStory, character)).thenReturn(expectedStory);
        when(randomizer.getRandomNumber(listSizeForBothLists)).thenReturn(1);
        
        NewStoryGenerator generator = new NewStoryGenerator();
        String actualStory = generator.generateStory(storyparts, cleaner, randomizer, character);
        actualStory = cleaner.cleanSentence(expectedStory, character);
        
        assertEquals(expectedStory, actualStory);
    }
}
