/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Dwarf;

import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Enums.Personality;
import CharacterGenerator.Interfaces.Randomizer;
import CharacterGenerator.NeutralGenerators.NeutralDeityGenerator;
import CharacterGenerator.NeutralGenerators.NeutralGenderGenerator;
import CharacterGenerator.NeutralGenerators.NeutralLikesGenerator;
import CharacterGenerator.NeutralGenerators.NeutralPersonalityGenerator;
import CharacterGenerator.NeutralGenerators.RandomNumberGenerator;

/**
 *
 * @author Greatmelons
 */
public class DwarfGenerator{

    /**
     *
     *
     * @return
     */
    public Dwarf generateCharacter() {

        Randomizer randomizer = new RandomNumberGenerator();

        Dwarf dwarf = new Dwarf(
                new NeutralDeityGenerator(randomizer),
                new NeutralPersonalityGenerator(randomizer),
                new NeutralGenderGenerator(randomizer),
                new NeutralLikesGenerator(randomizer),
                new DwarfFirstnameGenerator(randomizer),
                new DwarfLastnameGenerator(randomizer),
                new DwarfAgeGenerator(randomizer),
                new DwarfCityGenerator(randomizer));

        Personality personality = dwarf.getPersonality();
        Gender gender = dwarf.getGender();
        String race = "Dwarf";
        String firstname = dwarf.getFirstname();
        String lastname = dwarf.getLastname();
        String city = dwarf.getCity();
        String likes = dwarf.getLikes();
        int age = dwarf.getAge();
        String deity = dwarf.getDeity();
        return dwarf;
        //return String.format ("%s %s, %s %s, %d\nCity of birth: %s\nLikes: %s\nPersonality: %s", firstname, lastname, gender.getGenderAsText(),race , age, city, likes,personality.getPersonalityAsText());
    }

}
    
    

