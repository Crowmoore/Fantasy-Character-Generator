/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterGenerator.Interfaces;

import CharacterGenerator.Enums.Gender;
import CharacterGenerator.Enums.Personality;
import CharacterGenerator.Enums.Race;
import java.util.List;

/**
 *
 * @author nikok
 */
public interface ListProvider {

    List<String> getAdjectives();

    List<String> getBattles();

    List<String> getDeityList();

    List<String> getDiseases();

    List<String> getDwarfCityList();

    List<String> getDwarfFirstnameListF();

    List<String> getDwarfFirstnameListM();

    List<String> getDwarfLastnamePrefixList();

    List<String> getDwarfLastnameSuffixList();

    List<String> getElfCityList();

    List<String> getElfFirstnameListF();

    List<String> getElfFirstnameListM();

    List<String> getElfLastnameList();

    List<String> getEnemies();

    List<String> getEvents1();

    List<String> getEvents2();

    List<Gender> getGenders();

    List<String> getItems();

    List<String> getLikesDislikesList();

    List<String> getMovementVerbs();

    List<String> getOralVerbs();

    List<String> getPart1();

    List<String> getPart2();

    List<String> getPart3();

    List<String> getPart4();

    List<String> getPart5();

    List<Personality> getPersonalities();

    List<String> getProfessions();

    List<Race> getRaces();

    List<String> getSeasons();

    List<String> getWeapons();

    List<String> getWeather();
    
}
