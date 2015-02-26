/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class ListReader {
    
    public List<String> readFromFile(String filename) {
        
        BufferedReader bufferedReader = null;
        
        List<String> fileAsArray = new ArrayList<>();
        try {
            String currentLine;
            bufferedReader = new BufferedReader(new FileReader(filename));
            while ((currentLine = bufferedReader.readLine()) != null) {
                fileAsArray.add(currentLine);
            }
        } catch (IOException e) {
            System.out.printf("File: %s could not be found. Sadness..", filename);
        } finally {
            try {
                if (bufferedReader != null)bufferedReader.close();
            } catch (IOException e) {
                System.out.printf("File: %s could not be closed.", filename);
            }
        }
        return fileAsArray;
    }
}
