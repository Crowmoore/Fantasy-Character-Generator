/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package story;

import enums.Gender;
import enums.Personality;
import enums.Race;
import interfaces.ListProvider;
import java.util.Arrays;
import java.util.List;

/**
 * Provides a wanted ArrayList from enumerators or by calling the readFromFile method in ListReader class
 * @author Greatmelons
 */
public class ListProviderImpl implements ListProvider{

    ListReader reader;
    /**
     * Constructor for ListProviderImpl
     */
    public ListProviderImpl() {
        reader = new ListReader();
    }
    
    @Override
    public List<Gender> getGenders() {
        return Arrays.asList(Gender.values());
    }

    @Override
    public List<Personality> getPersonalities() {
        return Arrays.asList(Personality.values());
    }
    @Override
    public List<Race> getRaces() {
        return Arrays.asList(Race.values());
    }

    @Override
    public List<String> getElfFirstnameListM() {
        return reader.readFromFile("lists/elf/elfFirstnamesM.txt");
    }

    @Override
    public List<String> getElfFirstnameListF() {
        return reader.readFromFile("lists/elf/elfFirstnamesF.txt");
    }

    @Override
    public List<String> getElfLastnameList() {
        return reader.readFromFile("lists/elf/elfLastnames.txt");
    }

    @Override
    public List<String> getElfCityList() {
        return reader.readFromFile("lists/elf/elfCities.txt");
    }

    @Override
    public List<String> getDwarfFirstnameListM() {
        return reader.readFromFile("lists/dwarf/dwarfFirstnamesM.txt");
    }

    @Override
    public List<String> getDwarfFirstnameListF() {
        return reader.readFromFile("lists/dwarf/dwarfFirstnamesF.txt");
    }

    @Override
    public List<String> getDwarfLastnamePrefixList() {
        return reader.readFromFile("lists/dwarf/dwarfLastnamePrefix.txt");
    }

    @Override
    public List<String> getDwarfLastnameSuffixList() {
        return reader.readFromFile("lists/dwarf/dwarfLastnameSuffix.txt");
    }
    @Override
    public List<String> getDwarfCityList() {
        return reader.readFromFile("lists/dwarf/dwarfCities.txt");
    }
    @Override
    public List<String> getOrcFirstnameListM() {
        return reader.readFromFile("lists/orc/orcFirstnamesM.txt");
    }

    @Override
    public List<String> getOrcFirstnameListF() {
        return reader.readFromFile("lists/orc/orcFirstnamesF.txt");
    }

    @Override
    public List<String> getOrcLastnamePrefixList() {
        return reader.readFromFile("lists/orc/orcLastnamePrefix.txt");
    }

    @Override
    public List<String> getOrcLastnameSuffixList() {
        return reader.readFromFile("lists/orc/orcLastnameSuffix.txt");
    }

    @Override
    public List<String> getOrcCityList() {
        return reader.readFromFile("lists/orc/orcCities.txt");
    }

    @Override
    public List<String> getDeityList() {
        return reader.readFromFile("lists/deities.txt");
    }

    @Override
    public List<String> getLikesDislikesList() {
        return reader.readFromFile("lists/likes.txt");
    }

    @Override
    public List<String> getPart1() {
        return reader.readFromFile("lists/story/part1.txt");
    }

    @Override
    public List<String> getPart2() {
        return reader.readFromFile("lists/story/part2.txt");
    }

    @Override
    public List<String> getPart3() {
        return reader.readFromFile("lists/story/part3.txt");
    }

    @Override
    public List<String> getPart4() {
        return reader.readFromFile("lists/story/part4.txt");
    }

    @Override
    public List<String> getPart5() {
        return reader.readFromFile("lists/story/part5.txt");
    }
    
    @Override
    public List<String> getEvents1() {
        return reader.readFromFile("lists/story/events1.txt");
    }

    @Override
    public List<String> getEvents2() {
        return reader.readFromFile("lists/story/events2.txt");
    }

    @Override
    public List<String> getBattles() {
        return reader.readFromFile("lists/story/battles.txt");
    }

    @Override
    public List<String> getProfessions() {
        return reader.readFromFile("lists/story/professions.txt");
    }

    @Override
    public List<String> getItems() {
        return reader.readFromFile("lists/story/items.txt");
    }

    @Override
    public List<String> getAdjectives() {
        return reader.readFromFile("lists/story/adjectives.txt");
    }

    @Override
    public List<String> getWeapons() {
        return reader.readFromFile("lists/story/weapons.txt");
    }

    @Override
    public List<String> getWeather() {
        return reader.readFromFile("lists/story/weather.txt");
    }

    @Override
    public List<String> getEnemies() {
        return reader.readFromFile("lists/story/enemies.txt");
    }

    @Override
    public List<String> getSeasons() {
        return reader.readFromFile("lists/story/seasons.txt");
    }

    @Override
    public List<String> getDiseases() {
        return reader.readFromFile("lists/story/diseases.txt");
    }

    @Override
    public List<String> getMovementVerbs() {
        return reader.readFromFile("lists/story/movementVerbs.txt");
    }

    @Override
    public List<String> getOralVerbs() {
        return reader.readFromFile("lists/story/oralVerbs.txt");
    }

}
