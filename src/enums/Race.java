/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 * Enumerator for races
 * @author Greatmelons
 */
public enum Race {
    
    DWARF("Dwarf"),
    ELF("Elf"),
    ORC("Orc");
    
    String raceAsText;
    
    /**
     * Constructor for Race
     * @param raceAsText 
     */
    Race(String raceAsText) {
        this.raceAsText = raceAsText;
    }
    /**
     * Gets Race enumerator's value as a String
     * @return String raceAsText
     */
    public String getRaceAsText() {
        return this.raceAsText;
    }
    
}
