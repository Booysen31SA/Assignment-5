package com.Booysen31SA.factory.teacher.user.userDemography;

import com.Booysen31SA.domain.teacher.user.userDemography.UserDemography;

public class UserDemographyFactory {

    public static UserDemography buildUserDemography(String persal_Number, String genderId, String raceId) {
        return new UserDemography(persal_Number, genderId, raceId);
    }
}