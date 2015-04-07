/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CharacterGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import character.Character;
import interfaces.Randomizer;
import java.awt.Image;
import java.io.File;
import java.net.URLConnection;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import neutralGenerators.RandomNumberGenerator;
/**
 *
 * @author Greatmelons
 */
public class ImageLoader {
    
    static final Logger logger = Logger.getLogger(ImageLoader.class.getName());
    Randomizer randomizer = new RandomNumberGenerator();
    
    public ImageIcon loadImage(Character character) {
        BufferedReader reader = null;
        String jsonAsString = "";
        try {           
            URL search = new URL("http://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=fantasy%20artistic%20" + character.getRace().getRaceAsText() + "%20" + character.getGender().getGenderAsText());
            URLConnection connection = search.openConnection();
            connection.addRequestProperty("Referer", "https://github.com/Crowmoore/Character-Generator");
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            logger.log(Level.INFO, "Search URL: {0}", search.toString());
            String line;
            while((line = reader.readLine()) != null) {
                jsonAsString += line;
            }
            System.out.println(jsonAsString);
            
        } catch (IOException e) {
            logger.log(Level.WARNING, "Invalid URL", e);
            
        }finally {
            try {
                if (reader != null) { reader.close(); }
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Cannot close connection", e);
            }
        
        }
        Pattern pattern = Pattern.compile("\"unescapedUrl\":\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(jsonAsString);
        List imageURLs = new ArrayList<String>();
        while(matcher.find()) {
            imageURLs.add(matcher.group(1));
        }
        ImageIcon icon = null;
        ImageIcon errorIcon = null;
        try {
            URL imageURL = new URL(imageURLs.get(randomizer.getRandomNumber(imageURLs.size())).toString());
            logger.log(Level.INFO, "Image URL: " + imageURL.toString());
            Image image = ImageIO.read(imageURL);            
            Image resizedImage = image.getScaledInstance(200, 200, 0);
            icon = new ImageIcon(resizedImage);
        } catch (IOException e) {
            logger.log(Level.WARNING, "Invalid URL", e);            
            try {
                Image errorImg = ImageIO.read(new File("not-sure-if-this-is-a-bug-or-a-feature.jpg"));
                Image error = errorImg.getScaledInstance(200, 200, 0);
                errorIcon = new ImageIcon(error);
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Could not open file", ex);
            }
        }
        if(icon != null) { return icon; }
        else { return errorIcon; }
    }
    public ImageIcon loadFrame() {
        ImageIcon frame = null;
        try {
                Image frameImg = ImageIO.read(new File("frame.jpg"));
                frame = new ImageIcon(frameImg);
            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Could not open file", ex);
            }
        return frame;
        }
}

