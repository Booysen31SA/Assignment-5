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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserServiceImpl service;
    @Autowired
    @Qualifier("AddressServiceImpl")
    private AddressServiceImpl service2;
    @Autowired
    @Qualifier("AppointedServiceImpl")
    private AppointedServiceImpl service3;
    @Autowired
    @Qualifier("UserDemographyServiceImpl")
    private UserDemographyServiceImpl service4;
    @Autowired
    @Qualifier("GenderService")
    private GenderService service5;
    @Autowired
    @Qualifier("RaceService")
    private RaceService service6;

    @GetMapping("/test/{id}")
    @ResponseBody
    public String test(@PathVariable String id) {
        if (id.equalsIgnoreCase("1")) {
            return "Correct ID";
        } else {
            return "Wrong";
        }
    }

    public TeacherController() {
        service = UserServiceImpl.getService();
        service2 = AddressServiceImpl.getService();
        service3 = AppointedServiceImpl.getService();
        service4 = UserDemographyServiceImpl.getService();
        service5 = GenderService.getService();
        service6 = RaceService.getService();
    }

    @PostMapping(value = "/create")
    public ResponseEntity createA(@RequestBody TeacherCreation teacherCreation){



        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "User Created!");

        User user = teacherCreation.getUser();
        Address address = teacherCreation.getAddress();
        DateAppointed dateAppointed = teacherCreation.getDateAppointed();


        User buildUser;
        Address buildAddress;
        DateAppointed buildDateAppointed;
        UserDemography buildUserDemography;
        Gender buildGender;
        Race buildRace;

        User check = service.read(user.getPersal_Number());
        if(user == null){
            responseObj.setResponse(teacherCreation);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide an user!");
        }else if(address == null){
            responseObj.setResponse(teacherCreation);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide an address!");
        }else if(check != null){
            responseObj.setResponse(teacherCreation);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("User already exist!");
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

    @GetMapping("/read/{id}")
    public ResponseEntity read(@PathVariable String id){

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Get Teacher!");

        User buildUser = service.read(id);
        Address buildAddress = service2.read(id);
        DateAppointed buildDateAppointed = service3.read(id);

        if(buildUser == null){
            responseObj.setResponse(id);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("teacher Doesnt exist!");
        }else{
            TeacherCreation teacherCreation = new TeacherCreation(buildUser, buildDateAppointed, buildAddress);
            responseObj.setResponse(teacherCreation);
        }
        return ResponseEntity.ok(responseObj);
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Delete Teacher!");

        User buildUser = service.read(id);
        Address buildAddress = service2.read(id);
        DateAppointed buildDateAppointed = service3.read(id);

        if(buildUser == null){
            responseObj.setResponse(id);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("appointment Doesnt exist!");
        }else{
            TeacherCreation teacherCreation = new TeacherCreation(buildUser, buildDateAppointed, buildAddress);

            service.delete(buildUser.getPersal_Number());
            service2.delete(buildAddress.getPersal_Number());
            service3.delete(buildDateAppointed.getPersal_Number());
            responseObj.setResponse(teacherCreation);
        }
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping(value = "/update")
    public ResponseEntity update(@RequestBody TeacherCreation teacherCreation){



        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "User updated!");

        User user = teacherCreation.getUser();
        Address address = teacherCreation.getAddress();
        DateAppointed dateAppointed = teacherCreation.getDateAppointed();


        User buildUser;
        Address buildAddress;
        DateAppointed buildDateAppointed;
        UserDemography buildUserDemography;
        Gender buildGender;
        Race buildRace;

        User check = service.read(user.getPersal_Number());
        if(user == null){
            responseObj.setResponse(teacherCreation);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide an user!");
        }else if(address == null){
            responseObj.setResponse(teacherCreation);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide an address!");
        }else if(check == null){
            responseObj.setResponse(teacherCreation);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Dont exist!");
        }else{


            buildUser = UserFactory.buildUser(user.getPersal_Number(), user.getId(), user.getFirst_Names(), user.getLast_Name());
            buildAddress = AddressFactory.buildAddress(user.getPersal_Number(), address.getPhysicalAddress(), address.getPostalAddress());
            buildDateAppointed = DateAppointedFactory.buildDateAppointed(user.getPersal_Number(), dateAppointed.getDate());
//                buildUserDemography = UserDemographyFactory.buildUserDemography(user.getPersal_Number(), buildGender.getGenderId(), buildRace.getRaceId());

            service.update(buildUser);
            service2.update(buildAddress);
            service3.update(buildDateAppointed);
//                service4.create(buildUserDemography);
            responseObj.setResponse(teacherCreation);
        }

        return ResponseEntity.ok(responseObj);
    }
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Set<User> genders = service.getAll();
        responseObj.setResponse(genders);
        return ResponseEntity.ok(responseObj);
    }
}
