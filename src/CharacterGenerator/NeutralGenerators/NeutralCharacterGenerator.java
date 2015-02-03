/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.NeutralGenerators;

import CharacterGenerator.Dwarf.Dwarf;
import CharacterGenerator.Elf.Elf;
import CharacterGenerator.Interfaces.CharacterGenerator;
import CharacterGenerator.Interfaces.Randomizer;

/**
 *
 * @author Greatmelons
 */
public class NeutralCharacterGenerator implements CharacterGenerator, Randomizer{
    
    /**
     *
     * @param race
     * @return
     */
    @Override
    public String generateCharacter(String race) {
        
        if("Elf".equals(race)) {
            Elf elf = new Elf();
            String gender = elf.getGender();
            String firstname = elf.getFirstname(gender);
            String lastname = elf.getLastname();
            String city = elf.getCity();
            String likes = elf.getLikes();
            int age = elf.getAge();
            return String.format ("%s %s, %s %s, %d\nCity of birth: %s\nLikes: %s", firstname, lastname, race, gender, age, city, likes);
        }
        if("Dwarf".equals(race)) {
            Dwarf dwarf = new Dwarf();
            String gender = dwarf.getGender();
            String firstname = dwarf.getFirstname(gender);
            String lastname = dwarf.getLastname();
            String city = dwarf.getCity();
            String likes = dwarf.getLikes();
            int age = dwarf.getAge();
            return String.format ("%s %s, %s %s, %d\nCity of birth: %s\nLikes: %s", firstname, lastname, race, gender, age, city, likes);
        }
        else return "Something went horribly wrong! :( ";
        }
}
    
    

