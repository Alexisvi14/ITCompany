package com.solvd.enums;

public enum Speciality {
    FEND("Frontend"), BEND("Backend"), DB("Data Base"), MQAE("Manual QA Engineer"),
    TAE("Test Automation Engineer");

    private final String specLabel;

    private Speciality(String label) { this.specLabel = label;}

    public String getSpecLabel() {
        return specLabel;
    }

    @Override
    public String toString() { return specLabel; }
}
