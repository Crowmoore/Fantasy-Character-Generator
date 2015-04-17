/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package story;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Generates an ArrayList from a text file
 * @author Greatmelons
 */
public class ListReader {
    
    /**
     * Reads a text file into a List<String> fileAsArray
     * @param filename
     * @return List<String> fileAsArray
     */
    public List<String> readFromFile(String filename) {
        
        BufferedReader bufferedReader = null;
        Logger logger = Logger.getLogger(ListReader.class.getName());
        
        List<String> fileAsArray = new ArrayList<>();
        try {
            String currentLine;
            bufferedReader = new BufferedReader(new FileReader(filename));
            while ((currentLine = bufferedReader.readLine()) != null) {
                fileAsArray.add(currentLine);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "File could not be found.", e);
        } finally {
            try {
                if (bufferedReader != null) { bufferedReader.close(); }
            } catch (IOException e) {
                logger.log(Level.SEVERE, "File could not be closed.", e);
            }
        }
        return fileAsArray;
    }
}
