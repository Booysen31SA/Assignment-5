package com.Booysen31SA.controller.teacher;

import com.Booysen31SA.domain.ResponseObj;
import com.Booysen31SA.domain.teacher.user.userDemography.UserDemography;
import com.Booysen31SA.services.teacher.users.userDemography.impl.UserDemographyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userDemo")
public class UserDemographyController {

    @Autowired
    @Qualifier("UserDemographyServiceImpl")
    private UserDemographyServiceImpl service4;

    public UserDemographyController() {
        service4 = UserDemographyServiceImpl.getService();
    }

    @GetMapping("/read/{id}")
    public UserDemography read(@PathVariable String id){
        UserDemography buidUserDemography = service4.read(id);

        return buidUserDemography;
    }
}
