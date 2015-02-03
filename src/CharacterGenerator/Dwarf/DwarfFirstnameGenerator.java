/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Dwarf;

import CharacterGenerator.Interfaces.FirstnameGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Greatmelons
 */
public class DwarfFirstnameGenerator implements FirstnameGenerator, Randomizer{
    
    List<String> dwarfFirstnameListM = Arrays.asList("Thor", "Bjorn", "Lauger", "Ovur", "Varin", "Maof", "Garandas", "Vonthic", "Kilar", "Darnar", "Dwalbar", "Sundkas", "Garn", "Burgan", "Buror", "Donulf");
    List<String> dwarfFirstnameListF = Arrays.asList("Frira", "Vomisi", "Mardu", "Keshgi", "Badisi", "Tali", "Delamaka", "Tili", "Rari", "Aglaak", "Tiresli", "Tah", "Rakeba", "Tefdeth", "Ionu", "Niyrin", "Belra");
    
    /**
     *
     * @param gender
     * @return
     */
    @Override
    public String generateFirstname(String gender) {
        String firstname;
        if ("Male".equals(gender)) {
            firstname = dwarfFirstnameListM.get(randomizer.nextInt(dwarfFirstnameListM.size()));
            return firstname;
        }
        else {
            firstname = dwarfFirstnameListF.get(randomizer.nextInt(dwarfFirstnameListF.size()));
            return firstname;
        }
    }
    
}
