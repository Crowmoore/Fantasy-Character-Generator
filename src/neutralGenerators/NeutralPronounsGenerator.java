/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neutralGenerators;

import enums.Gender;
import enums.Pronouns;

/**
 *
 * @author Greatmelons
 */
public class NeutralPronounsGenerator{
    /**
     * Generates a subjective pronoun from Pronouns enumerator for a character based on gender
     * @param gender
     * @return String pronoun
     */
    public String getSubjective(Gender gender) {
        switch(gender) {
            case MALE: return Pronouns.HE.getPronounAsText(); 
            default: return Pronouns.SHE.getPronounAsText();
        }
    }
    /**
     * Generates a objective pronoun from Pronouns enumerator for a character based on gender
     * @param gender
     * @return String pronoun
     */
    public String getObjective(Gender gender) {
        switch(gender) {
            case MALE: return Pronouns.HIM.getPronounAsText(); 
            default: return Pronouns.HER.getPronounAsText();
        }
    }
    /**
     * Generates a possessive pronoun from Pronouns enumerator for a character based on gender 
     * @param gender
     * @return String pronoun
     */
    public String getPossessive(Gender gender) {
        switch(gender) {
            case MALE: return Pronouns.HIS.getPronounAsText(); 
            default: return Pronouns.HERS.getPronounAsText();
        }
    }
    /**
     * Generates a possessive adjective pronoun from Pronouns enumerator for a character based on gender
     * @param gender
     * @return String pronoun
     */
    public String getPossessiveAdj(Gender gender) {
        switch(gender) {
            case MALE: return Pronouns.HIS.getPronounAsText(); 
            default: return Pronouns.HER.getPronounAsText();
        }
    }
    /**
     * Generates a reflexive pronoun from Pronouns enumerator for a character based on gender
     * @param gender
     * @return String pronoun
     */
    public String getReflexive(Gender gender) {
        switch(gender) {
            case MALE: return Pronouns.HIMSELF.getPronounAsText(); 
            default: return Pronouns.HERSELF.getPronounAsText();
        }
    }
    
}
