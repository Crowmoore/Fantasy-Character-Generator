package enums;

/**
 * Created by Greatmelons on 5.2.2015.
 */
public enum Gender {

    MALE("Male"),
    FEMALE("Female");

    String genderAsText;

    Gender(String genderAsText) {
        this.genderAsText = genderAsText;
    }
    public String getGenderAsText() {
        return this.genderAsText;
    }
}
