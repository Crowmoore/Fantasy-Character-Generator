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
public enum Personality {
    
    CALM("Calm"),
    AGGRESSIVE("Aggressive"),
    INSANE("Insane"),
    PEACEFULL("Peacefull"),
    PARANOID("Paranoid"),
    MAD("Mad");
    
    String personalityAsText;
    
    Personality(String personalityAsText) {
        this.personalityAsText = personalityAsText;
    }
    public String getPersonalityAsText() {
        return this.personalityAsText;
    }
    
    
}
