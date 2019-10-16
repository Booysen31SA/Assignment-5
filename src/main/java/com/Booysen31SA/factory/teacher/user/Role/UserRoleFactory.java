package com.Booysen31SA.factory.teacher.user.Role;

import com.Booysen31SA.domain.teacher.user.Role.UserRole;

import javax.persistence.Entity;
import javax.persistence.Id;


public class UserRoleFactory {
   public static UserRole BuildUserRole(String persal_Number, String userRole, String userPassword){
       return new UserRole(persal_Number, userRole, userPassword);
   }
}
