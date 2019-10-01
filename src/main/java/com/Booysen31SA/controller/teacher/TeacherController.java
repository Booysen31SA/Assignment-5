package com.Booysen31SA.controller.teacher;

import com.Booysen31SA.domain.ResponseObj;
import com.Booysen31SA.domain.teacher.demography.Gender;
import com.Booysen31SA.domain.teacher.demography.Race;
import com.Booysen31SA.domain.teacher.user.User;
import com.Booysen31SA.domain.teacher.user.address.Address;
import com.Booysen31SA.domain.teacher.user.appointed.DateAppointed;
import com.Booysen31SA.domain.teacher.user.userDemography.UserDemography;
import com.Booysen31SA.factory.ResponseObjFactory;
import com.Booysen31SA.factory.appointment.DateAndTimeFactory;
import com.Booysen31SA.factory.teacher.demography.GenderFactory;
import com.Booysen31SA.factory.teacher.user.UserFactory;
import com.Booysen31SA.factory.teacher.user.address.AddressFactory;
import com.Booysen31SA.factory.teacher.user.appointed.DateAppointedFactory;
import com.Booysen31SA.factory.teacher.user.userDemography.UserDemographyFactory;
import com.Booysen31SA.services.teacher.demography.impl.GenderService;
import com.Booysen31SA.services.teacher.demography.impl.RaceService;
import com.Booysen31SA.services.teacher.users.UserServiceImpl;
import com.Booysen31SA.services.teacher.users.address.impl.AddressServiceImpl;
import com.Booysen31SA.services.teacher.users.appointed.impl.AppointedServiceImpl;
import com.Booysen31SA.services.teacher.users.userDemography.impl.UserDemographyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @GetMapping("/test/{id}")
    @ResponseBody
    public String test(@PathVariable String id) {
        if (id.equalsIgnoreCase("1")) {
            return "Correct ID";
        } else {
            return "Wrong";
        }
    }

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserServiceImpl service;
    @Qualifier("AddressServiceImpl")
    private AddressServiceImpl service2;
    @Qualifier("AppointedServiceImpl")
    private AppointedServiceImpl service3;
    @Qualifier("UserDemographyServiceImpl")
    private UserDemographyServiceImpl service4;
    @Qualifier("GenderService")
    private GenderService service5;
    @Qualifier("RaceService")
    private RaceService service6;

    @PostMapping(value = "/create")
    public ResponseEntity createA(@RequestBody TeacherCreation teacherCreation){
        service = UserServiceImpl.getService();
        service2 = AddressServiceImpl.getService();
        service3 = AppointedServiceImpl.getService();
        service4 = UserDemographyServiceImpl.getService();
        service5 = GenderService.getService();
        service6 = RaceService.getService();

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "User Created created!");

        User user = teacherCreation.getUser();
        Address address = teacherCreation.getAddress();
        DateAppointed dateAppointed = teacherCreation.getDateAppointed();


        User buildUser;
        Address buildAddress;
        DateAppointed buildDateAppointed;
        UserDemography buildUserDemography;
        Gender buildGender;
        Race buildRace;

        if(user == null){
            responseObj.setResponse(teacherCreation);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide an user!");
        }else if(address == null){
            responseObj.setResponse(teacherCreation);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide an address!");
        }else{


                buildUser = UserFactory.buildUser(user.getPersal_Number(), user.getId(), user.getFirst_Names(), user.getLast_Name());
                buildAddress = AddressFactory.buildAddress(user.getPersal_Number(), address.getPhysicalAddress(), address.getPostalAddress());
                buildDateAppointed = DateAppointedFactory.buildDateAppointed(user.getPersal_Number(), dateAppointed.getDate());
//                buildUserDemography = UserDemographyFactory.buildUserDemography(user.getPersal_Number(), buildGender.getGenderId(), buildRace.getRaceId());

                service.create(buildUser);
                service2.create(buildAddress);
                service3.create(buildDateAppointed);
//                service4.create(buildUserDemography);
                responseObj.setResponse(teacherCreation);
            }

        return ResponseEntity.ok(responseObj);
    }

}
