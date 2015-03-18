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
public enum Race {
    
    DWARF("Dwarf"),
    ELF("Elf");
    
    String raceAsText;
    
    Race(String raceAsText) {
        this.raceAsText = raceAsText;
    }
    public String getRaceAsText() {
        return raceAsText;
    }
    
}
