/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Greatmelons
 */
public enum Pronouns {
    
    HE("He"),
    SHE("She"),
    HIM("Him"),
    HER("Her"),
    HIS("His"),
    HERS("Hers"),
    HIMSELF("Himself"),
    HERSELF("Herself");
    
    String pronounAsText;
    
    Pronouns(String pronounAsText) {
        this.pronounAsText = pronounAsText;
    }
    public String getPronounAsText() {
        return pronounAsText;
    }
    
}
