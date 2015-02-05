/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Dwarf;

import CharacterGenerator.Dwarf.Dwarf;
import CharacterGenerator.Elf.*;
import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Interfaces.CharacterGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import CharacterGenerator.NeutralGenerators.NeutralGenderGenerator;
import CharacterGenerator.NeutralGenerators.NeutralLikesGenerator;
import CharacterGenerator.NeutralGenerators.RandomNumberGenerator;

/**
 *
 * @author Greatmelons
 */
public class DwarfGenerator implements CharacterGenerator{

    /**
     *
     *
     * @return
     */
    @Override
    public String generateCharacter() {

        Randomizer randomizer = new RandomNumberGenerator();

        Dwarf dwarf = new Dwarf(
                new NeutralGenderGenerator(randomizer),
                new NeutralLikesGenerator(randomizer),
                new ElfFirstnameGenerator(randomizer),
                new ElfLastnameGenerator(randomizer),
                new ElfAgeGenerator(randomizer),
                new ElfCityGenerator(randomizer));

        Gender gender = dwarf.getGender();
        String firstname = dwarf.getFirstname();
        String lastname = dwarf.getLastname();
        String city = dwarf.getCity();
        String likes = dwarf.getLikes();
        int age = dwarf.getAge();
        return String.format ("%s %s, %s, %d\nCity of birth: %s\nLikes: %s", firstname, lastname, gender.getGenderAsText(), age, city, likes);
    }

}
    
    

