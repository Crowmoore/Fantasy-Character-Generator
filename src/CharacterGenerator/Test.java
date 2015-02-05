/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator;

import CharacterGenerator.Dwarf.Dwarf;
import CharacterGenerator.Dwarf.DwarfGenerator;
import CharacterGenerator.Elf.ElfGenerator;
import CharacterGenerator.NeutralGenerators.NeutralRaceGenerator;

import java.util.logging.Logger;

/**
 *
 * @author Greatmelons
 */
public class Test {

    Logger log = Logger.getLogger(Test.class.getName());

    public void run() {        

        log.info("Starting");
        ElfGenerator elfGenerator = new ElfGenerator();
        DwarfGenerator dwarfGenerator = new DwarfGenerator();
        String dwarf = dwarfGenerator.generateCharacter();
        String elf = elfGenerator.generateCharacter();
        System.out.println(dwarf + "\n" + elf);
    }
    
}
