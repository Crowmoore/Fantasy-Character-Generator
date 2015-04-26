/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import enums.Gender;

/**
 *
 * @author Greatmelons
 */
public interface PronounsGenerator {
    
    public String getSubjective(Gender gender);
    
    public String getObjective(Gender gender);
    
    public String getPossessive(Gender gender);
    
    public String getPossessiveAdj(Gender gender);
    
    public String getReflexive(Gender gender);
}
