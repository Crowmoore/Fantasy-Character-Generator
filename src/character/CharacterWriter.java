/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Writes saved characters to a local drive
 * @author Greatmelons
 */
public class CharacterWriter {
    
    /**
     * Writes elements from ArrayList into a binary file characters.bin
     * @param characterList 
     */
    public void writeCharacterToFile(List characterList) {
        
        List<Character> characters = characterList;
        Logger logger = Logger.getLogger(CharacterWriter.class.getName());
        ObjectOutputStream characterOut = null;
        
        try {
            characterOut = new ObjectOutputStream(new FileOutputStream("lists/characters/characters.bin"));
            for(Character character : characters) {
                characterOut.writeObject(character);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Could not find file characters.bin", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Could not write characters to file", e);
        } finally {
            try {
                if (characterOut != null) { characterOut.close(); }
            } catch (IOException e) {
                logger.log(Level.SEVERE, "File could not be opened", e);
            }
        }
}
}