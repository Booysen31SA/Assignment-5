package com.Booysen31SA.domain.teacher.user.Role;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserRole {
    @Id
    private String persal_Number;
    private String userRole;
    private String userPassword;

    public UserRole() {
    }

    public UserRole(String persal_Number, String userRole, String userPassword) {
        this.persal_Number = persal_Number;
        this.userRole = userRole;
        this.userPassword = userPassword;
    }

    public String getPersal_Number() {
        return persal_Number;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
