package com.Booysen31SA.controller;

import com.Booysen31SA.domain.teacher.user.Role.UserRole;
import com.Booysen31SA.factory.teacher.user.Role.UserRoleFactory;
import com.Booysen31SA.services.teacher.users.userRole.Impl.UserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Autowired
    @Qualifier("UserRoleServiceImpl")
    private UserRoleServiceImpl service;

    public UserRoleController() {
        service = UserRoleServiceImpl.getService();
    }

    @GetMapping("/getRole/{id}")
    @ResponseBody
    public UserRole getUser (@PathVariable String id){

        UserRole userRole = service.read(id);
        UserRole buildUserRole;

        if(userRole == null){
            buildUserRole = UserRoleFactory.BuildUserRole(null, null, null);
        }else{
            buildUserRole = UserRoleFactory.BuildUserRole(userRole.getPersal_Number(), userRole.getUserRole(), userRole.getUserPassword());
        }
        return buildUserRole;
    }
}
