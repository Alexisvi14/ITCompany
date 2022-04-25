package com.solvd.enums;

public enum Gender {
    M("Male"), F("Female"), UNKNOWN("Unknown or not specified");

    private final String genderLabel;

    private Gender (String label) {this.genderLabel = label;}

    public String getGenderLabel() {
        return genderLabel;
    }

    @Override
    public String toString() {return genderLabel;}
}
