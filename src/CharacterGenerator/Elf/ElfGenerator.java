package CharacterGenerator.Elf;

import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Interfaces.CharacterGenerator;
import CharacterGenerator.Interfaces.Randomizer;
import CharacterGenerator.NeutralGenerators.NeutralGenderGenerator;
import CharacterGenerator.NeutralGenerators.NeutralLikesGenerator;
import CharacterGenerator.NeutralGenerators.RandomNumberGenerator;
import CharacterGenerator.NeutralGenerators.SeededGenerator;

/**
 * Created by Greatmelons on 5.2.2015.
 */
public class ElfGenerator implements CharacterGenerator {

    public String generateCharacter() {

        Randomizer randomizer = new SeededGenerator(84365839);

        Elf elf = new Elf(
                new NeutralGenderGenerator(randomizer),
                new NeutralLikesGenerator(randomizer),
                new ElfFirstnameGenerator(randomizer),
                new ElfLastnameGenerator(randomizer),
                new ElfAgeGenerator(randomizer),
                new ElfCityGenerator(randomizer));

            Gender gender = elf.getGender();
            String firstname = elf.getFirstname();
            String lastname = elf.getLastname();
            String city = elf.getCity();
            String likes = elf.getLikes();
            int age = elf.getAge();
            return String.format("%s %s, %s, %d\nCity of birth: %s\nLikes: %s",firstname,lastname,gender.getGenderAsText(),age,city,likes);
        }
}
