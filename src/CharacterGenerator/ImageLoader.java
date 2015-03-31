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
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URLConnection;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import neutralGenerators.RandomNumberGenerator;
/**
 *
 * @author h3090
 */
public class ImageLoader {
    
    Logger logger = Logger.getLogger(ImageLoader.class.getName());
    BufferedReader reader = null;
    String result;
    Randomizer randomizer = new RandomNumberGenerator();
    
    public ImageIcon loadImage(Character character) {

        try {
            URL imageURL = new URL("http://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=fantasy%20" + character.getRace().getRaceAsText() + "%20" + character.getGender().getGenderAsText());
            URLConnection connection = imageURL.openConnection();
            connection.addRequestProperty("Referer", "https://github.com/Crowmoore/Character-Generator");
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            logger.log(Level.INFO, "Search URL: " + imageURL.toString());
            String line;
            while((line = reader.readLine()) != null) {
                result += line;
            }
            System.out.println(result);
            
        } catch (Exception e) {
            logger.log(Level.WARNING, "Invalid URL", e);
            
        }finally {
            try {
                if (reader != null) { reader.close(); }
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Cannot close connection", e);
            }
        
        }
        Pattern pattern = Pattern.compile("\"unescapedUrl\":\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(result);
        List imageURLs = new ArrayList<String>();
        while(matcher.find()) {
            imageURLs.add(matcher.group(1));
        }
        ImageIcon icon = null;
        Image errorImg = null;
        ImageIcon errorIcon = null;
        try {
            URL url = new URL(imageURLs.get(randomizer.getRandomNumber(imageURLs.size())).toString());
            logger.log(Level.INFO, "Image URL: " + url.toString());
            Image image = ImageIO.read(url);            
            Image finalImage = image.getScaledInstance(200, 200, 0);
            icon = new ImageIcon(finalImage);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Invalid URL", e);            
            try {
                File file = new File("not-sure-if-this-is-a-bug-or-a-feature.jpg");
                errorImg = ImageIO.read(file);
                Image error = errorImg.getScaledInstance(200, 200, 0);
                errorIcon = new ImageIcon(error);
            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Could not open file", ex);
            }
        }
        if(icon != null) { return icon; }
        else { return errorIcon; }
    }
}
