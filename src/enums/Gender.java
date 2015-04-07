package enums;

/**
 * Created by Greatmelons on 5.2.2015.
 */
public enum Gender {

    MALE("Male"),
    FEMALE("Female");

    String genderAsText;
    
    /**
     * Constructor for Gender
     * @param genderAsText 
     */
    Gender(String genderAsText) {
        this.genderAsText = genderAsText;
    }
    /**
     * Gets Gender enumerator's value as a String
     * @return String genderAsText
     */
    public String getGenderAsText() {
        return this.genderAsText;
    }
}
