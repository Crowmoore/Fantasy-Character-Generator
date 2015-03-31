/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CharacterGenerator;

import enums.Gender;
import enums.Race;
import java.awt.Image;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author h3090
 */
public class ImageLoader {
    
    Logger logger = Logger.getLogger(ImageLoader.class.getName());
    
    public void loadImage(Race race, Gender gender) {
        //Need a JSON parser
        try {
            URL imageURL = new URL("http://enliighten.com/wp-content/uploads/2011/10/dwarf_slayer_web.jpg");      
            Image image = ImageIO.read(imageURL);
            Image resized = image.getScaledInstance(200, 200, 0);
            
        } catch (Exception e) {
            logger.log(Level.WARNING, "Invalid URL", e);
        }        
    }
    
}
