/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import enums.Gender;
import enums.Personality;
import enums.Race;
import java.util.List;

/**
 *
 * @author Greatmelons
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
    
    List<String> getOrcCityList();

    List<String> getOrcFirstnameListF();

    List<String> getOrcFirstnameListM();

    List<String> getOrcLastnamePrefixList();

    List<String> getOrcLastnameSuffixList();
    
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
