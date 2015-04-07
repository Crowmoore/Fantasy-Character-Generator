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
public interface FirstnameGenerator {
    /**
     * Abstract method generateFirstname
     * @param gender
     * @return String
     */
    public String generateFirstname(Gender gender);
    
}
