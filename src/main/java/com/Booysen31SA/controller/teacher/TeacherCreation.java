package com.Booysen31SA.controller.teacher;

import com.Booysen31SA.domain.teacher.demography.Gender;
import com.Booysen31SA.domain.teacher.demography.Race;
import com.Booysen31SA.domain.teacher.user.User;
import com.Booysen31SA.domain.teacher.user.address.Address;
import com.Booysen31SA.domain.teacher.user.appointed.DateAppointed;
import com.Booysen31SA.domain.teacher.user.userDemography.UserDemography;

public class TeacherCreation {

    private User user;
    private DateAppointed dateAppointed;
    private Address address;
    private Gender gender;
    private Race race;

    public TeacherCreation() {
    }

    public TeacherCreation(User user, DateAppointed dateAppointed, Address address) {
        this.user = user;
        this.dateAppointed = dateAppointed;
        this.address = address;
        this.gender = null;
        this.race = null;
    }
    public TeacherCreation(User user, DateAppointed dateAppointed, Address address, Gender gender, Race race) {
        this.user = user;
        this.dateAppointed = dateAppointed;
        this.address = address;
        this.gender = gender;
        this.race = race;
    }

    public User getUser() {
        return user;
    }

    public DateAppointed getDateAppointed() {
        return dateAppointed;
    }

    public Address getAddress() {
        return address;
    }

    public Gender getGender() {
        return gender;
    }

    public Race getRace() {
        return race;
    }
}
