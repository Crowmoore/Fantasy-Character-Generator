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
public enum SubjectPronoun {
    
    HE("He"),
    SHE("She");
    
    String pronounAsText;
    
    SubjectPronoun(String pronounAsText) {
        this.pronounAsText = pronounAsText;
    }
    public String getPronounAsText() {
        return pronounAsText;
    }
    
}
