/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.NeutralGenerators;

import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Enums.Pronouns;

/**
 *
 * @author Greatmelons
 */
public class NeutralPronounsGenerator{
    
    public String getSubjective(Gender gender) {
        switch(gender) {
            case MALE: return Pronouns.HE.getPronounAsText(); 
            default: return Pronouns.SHE.getPronounAsText();
        }
    }
    public String getObjective(Gender gender) {
        switch(gender) {
            case MALE: return Pronouns.HIM.getPronounAsText(); 
            default: return Pronouns.HER.getPronounAsText();
        }
    }    
    public String getPossessive(Gender gender) {
        switch(gender) {
            case MALE: return Pronouns.HIS.getPronounAsText(); 
            default: return Pronouns.HERS.getPronounAsText();
        }
    }
    public String getPossessiveAdj(Gender gender) {
        switch(gender) {
            case MALE: return Pronouns.HIS.getPronounAsText(); 
            default: return Pronouns.HER.getPronounAsText();
        }
    }
    public String getReflexive(Gender gender) {
        switch(gender) {
            case MALE: return Pronouns.HIMSELF.getPronounAsText(); 
            default: return Pronouns.HERSELF.getPronounAsText();
        }
    }
    
}
