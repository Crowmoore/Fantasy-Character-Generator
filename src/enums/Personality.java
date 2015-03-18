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
public enum Personality {
    
    CALM("calm"),
    AGGRESSIVE("aggressive"),
    INSANE("insane"),
    PEACEFULL("peacefull"),
    PARANOID("paranoid"),
    MAD("mad"),
    ADVENTUROUS("adventurous"),
    PLAYFUL("playful");
    
    String personalityAsText;
    
    Personality(String personalityAsText) {
        this.personalityAsText = personalityAsText;
    }
    public String getPersonalityAsText() {
        return this.personalityAsText;
    }
    
    
}
