package com.Booysen31SA.factory.teacher.user;

import com.Booysen31SA.domain.teacher.user.User;

public class UserFactory {
    public static User buildUser(String persal_Number, String id, String first_Names, String last_Name){
        return new User.Builder()
                .persal_Number(persal_Number)
                .id(id)
                .first_Names(first_Names)
                .last_Name(last_Name)
                .build();
    }
}