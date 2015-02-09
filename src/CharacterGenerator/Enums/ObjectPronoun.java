/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Enums;

/**
 *
 * @author Greatmelons
 */
public enum ObjectPronoun {
    
    HIM("Him"),
    HER("Her");
    
    String pronounAsText;
    
    ObjectPronoun(String pronounAsText) {
        this.pronounAsText = pronounAsText;
    }
    public String getPronounAsText() {
        return pronounAsText;
    }
    
}
