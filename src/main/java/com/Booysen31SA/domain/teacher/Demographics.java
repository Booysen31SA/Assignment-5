package com.Booysen31SA.domain.teacher;

public class Demographics {

    private String gender;
    private String race;

    public Demographics(String gender, String race) {
        this.gender = gender;
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

}
