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
        if(gender.MALE == gender) { return Pronouns.HE.getPronounAsText(); }
        else return Pronouns.SHE.getPronounAsText();
        }
    public String getObjective(Gender gender) {
        if(gender.MALE == gender) { return Pronouns.HIM.getPronounAsText(); }
        else return Pronouns.HER.getPronounAsText();
    }
    public String getPossessive(Gender gender) {
        if(gender.MALE == gender) { return Pronouns.HIS.getPronounAsText(); }
        else return Pronouns.HERS.getPronounAsText();
    }
    public String getPossessiveAdj(Gender gender) {
        if(gender.MALE == gender) { return Pronouns.HIS.getPronounAsText(); }
        else return Pronouns.HER.getPronounAsText();
    }
    public String getReflexive(Gender gender) {
        if(gender.MALE == gender) { return Pronouns.HIMSELF.getPronounAsText(); }
        else return Pronouns.HERSELF.getPronounAsText();
    }
    
}
