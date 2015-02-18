package CharacterGenerator.Elf;

import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Interfaces.CharacterGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import CharacterGenerator.NeutralGenerators.NeutralGenderGenerator;
import CharacterGenerator.NeutralGenerators.NeutralLikesGenerator;
import CharacterGenerator.NeutralGenerators.SeededGenerator;
import CharacterGenerator.Enums.Personality;
import CharacterGenerator.NeutralGenerators.NeutralDeityGenerator;
import CharacterGenerator.NeutralGenerators.NeutralPersonalityGenerator;
import CharacterGenerator.NeutralGenerators.RandomNumberGenerator;

/**
 * Created by Greatmelons on 5.2.2015.
 */
public class ElfGenerator {

    /**
     *
     * @return
     */
    public Elf generateCharacter() {

        Randomizer randomizer = new RandomNumberGenerator();

        Elf elf = new Elf(
                new NeutralDeityGenerator(randomizer),
                new NeutralPersonalityGenerator(randomizer),
                new NeutralGenderGenerator(randomizer),
                new NeutralLikesGenerator(randomizer),
                new ElfFirstnameGenerator(randomizer),
                new ElfLastnameGenerator(randomizer),
                new ElfAgeGenerator(randomizer),
                new ElfCityGenerator(randomizer));
        
            Personality personality = elf.getPersonality();
            Gender gender = elf.getGender();
            String race = "Elf";
            String firstname = elf.getFirstname();
            String lastname = elf.getLastname();
            String city = elf.getCity();
            String likes = elf.getLikes();
            int age = elf.getAge();
            String deity = elf.getDeity();
            return elf;
            //return String.format("%s %s, %s %s, %d\nCity of birth: %s\nLikes: %s\nPersonality: %s",firstname,lastname,gender.getGenderAsText(),race ,age,city,likes,personality.getPersonalityAsText());
        }
}
