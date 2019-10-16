package com.Booysen31SA.controller.teacher;

import com.Booysen31SA.domain.ResponseObj;
import com.Booysen31SA.domain.teacher.demography.Gender;
import com.Booysen31SA.domain.teacher.demography.Race;
import com.Booysen31SA.domain.teacher.user.Role.UserRole;
import com.Booysen31SA.domain.teacher.user.User;
import com.Booysen31SA.domain.teacher.user.address.Address;
import com.Booysen31SA.domain.teacher.user.appointed.DateAppointed;
import com.Booysen31SA.domain.teacher.user.userDemography.UserDemography;
import com.Booysen31SA.factory.ResponseObjFactory;
import com.Booysen31SA.factory.appointment.DateAndTimeFactory;
import com.Booysen31SA.factory.teacher.demography.GenderFactory;
import com.Booysen31SA.factory.teacher.user.Role.UserRoleFactory;
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
import com.Booysen31SA.services.teacher.users.userRole.Impl.UserRoleServiceImpl;
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
    @Autowired
    @Qualifier("UserRoleServiceImpl")
    private UserRoleServiceImpl service7;

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
        service7 = UserRoleServiceImpl.getService();
    }

    @PostMapping(value = "/create/{gender}/{race}")
    public TeacherCreation createA(@RequestBody TeacherCreation teacherCreation, @PathVariable String gender, @PathVariable String race){

        User user = teacherCreation.getUser();
        Address address = teacherCreation.getAddress();
        DateAppointed dateAppointed = teacherCreation.getDateAppointed();
        Gender genderCheck = service5.getByName(gender);
        Race raceCheck = service6.getByName(race);
        UserRole userRole = teacherCreation.getUserRole();


        User buildUser = null;
        Address buildAddress = null;
        DateAppointed buildDateAppointed = null;
        UserDemography buildUserDemography = null;
        Gender buildGender = null;
        Race buildRace = null;
        UserRole buildUserRole = null;

        User check = service.read(user.getPersal_Number());
        if(user == null){
            buildUser = UserFactory.buildUser(user.getPersal_Number(), user.getId(), user.getFirst_Names(), user.getLast_Name());
            buildAddress = AddressFactory.buildAddress(user.getPersal_Number(), address.getPhysicalAddress(), address.getPostalAddress());
            buildDateAppointed = DateAppointedFactory.buildDateAppointed(user.getPersal_Number(), dateAppointed.getDate());
            buildUserDemography = UserDemographyFactory.buildUserDemography(user.getPersal_Number(), genderCheck.getGenderId(), raceCheck.getRaceId());
            buildUserRole = UserRoleFactory.BuildUserRole(user.getPersal_Number(), userRole.getUserRole(), userRole.getUserPassword());
        }else if(address == null){

        }else if(check != null){

        }else {

            if (genderCheck == null) {

            } else if (raceCheck == null) {

            } else {
                buildUser = UserFactory.buildUser(user.getPersal_Number(), user.getId(), user.getFirst_Names(), user.getLast_Name());
                buildAddress = AddressFactory.buildAddress(user.getPersal_Number(), address.getPhysicalAddress(), address.getPostalAddress());
                buildDateAppointed = DateAppointedFactory.buildDateAppointed(user.getPersal_Number(), dateAppointed.getDate());
                buildUserDemography = UserDemographyFactory.buildUserDemography(user.getPersal_Number(), genderCheck.getGenderId(), raceCheck.getRaceId());
                buildUserRole = UserRoleFactory.BuildUserRole(user.getPersal_Number(), userRole.getUserRole(), userRole.getUserPassword());
                service.create(buildUser);
                service2.create(buildAddress);
                service3.create(buildDateAppointed);
                service4.create(buildUserDemography);
                service7.create(buildUserRole);
            }
        }
        return new TeacherCreation(buildUser, buildDateAppointed, buildAddress, buildUserRole);
    }

    @GetMapping("/read/{id}")
    public TeacherCreation read(@PathVariable String id){

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Get Teacher!");

        User buildUser = service.read(id);
        Address buildAddress = service2.read(id);
        DateAppointed buildDateAppointed = service3.read(id);
        UserDemography user = service4.read(id);
        UserRole userRole = service7.read(id);

        if(buildUser == null){
            responseObj.setResponse(id);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("teacher Doesnt exist!");
        }else{
            Gender checkGender = service5.read(user.getGenderId());
            Race checkRace = service6.read(user.getRaceId());
            TeacherCreation teacherCreation = new TeacherCreation(buildUser, buildDateAppointed, buildAddress,checkGender,checkRace,userRole);
            responseObj.setResponse(teacherCreation);
        }
        return new TeacherCreation(buildUser, buildDateAppointed, buildAddress, userRole);
    }


    @GetMapping("/delete/{id}")
    public TeacherCreation delete(@PathVariable String id){

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Delete Teacher!");

        User buildUser = service.read(id);
        Address buildAddress = service2.read(id);
        DateAppointed buildDateAppointed = service3.read(id);
        UserDemography user = service4.read(id);
        UserRole userRole = service7.read(id);

        if(buildUser == null){
            responseObj.setResponse(id);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("appointment Doesnt exist!");
        }else{
            Gender checkGender = service5.read(user.getGenderId());
            Race checkRace = service6.read(user.getRaceId());
            TeacherCreation teacherCreation = new TeacherCreation(buildUser, buildDateAppointed, buildAddress,checkGender,checkRace, userRole);

            service.delete(buildUser.getPersal_Number());
            service2.delete(buildUser.getPersal_Number());
            service3.delete(buildUser.getPersal_Number());
            service4.delete(buildUser.getPersal_Number());
            responseObj.setResponse(teacherCreation);
        }
        return new TeacherCreation(buildUser, buildDateAppointed, buildAddress, userRole);
    }

    @PostMapping(value = "/update/{gender}/{race}")
    public TeacherCreation update(@RequestBody TeacherCreation teacherCreation, @PathVariable String gender, @PathVariable String race){

        User user = teacherCreation.getUser();
        Address address = teacherCreation.getAddress();
        DateAppointed dateAppointed = teacherCreation.getDateAppointed();
        Gender genderCheck = service5.getByName(gender);
        Race raceCheck = service6.getByName(race);
        UserRole userRole = teacherCreation.getUserRole();


        User buildUser = null;
        Address buildAddress = null;
        DateAppointed buildDateAppointed = null;
        UserDemography buildUserDemography = null;
        Gender buildGender = null;
        Race buildRace = null;
        UserRole buildUserRole = null;

        User check = service.read(user.getPersal_Number());
        if(user == null){
            buildUser = UserFactory.buildUser(null, null, null,null);
        }else if(address == null){
            buildAddress = AddressFactory.buildAddress(null, null,null);
        }else if(check != null){
            buildUser = UserFactory.buildUser(null, null, null,null);
        }else {
                buildUser = UserFactory.buildUser(user.getPersal_Number(), user.getId(), user.getFirst_Names(), user.getLast_Name());
                buildAddress = AddressFactory.buildAddress(user.getPersal_Number(), address.getPhysicalAddress(), address.getPostalAddress());
                buildDateAppointed = DateAppointedFactory.buildDateAppointed(user.getPersal_Number(), dateAppointed.getDate());
                buildUserDemography = UserDemographyFactory.buildUserDemography(user.getPersal_Number(), genderCheck.getGenderId(), raceCheck.getRaceId());
                buildUserRole = UserRoleFactory.BuildUserRole(user.getPersal_Number(), userRole.getUserRole(), userRole.getUserPassword());
                service.create(buildUser);
                service2.create(buildAddress);
                service3.create(buildDateAppointed);
                service4.create(buildUserDemography);
                service7.create(buildUserRole);
            }
        return new TeacherCreation(buildUser, buildDateAppointed, buildAddress, buildUserRole);
    }

    @GetMapping(value = "/getall/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<User> getAllUsers(){
        Set<User> user = service.getAll();
        return user;
    }
    @GetMapping(value = "/getall/address", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Address> getAllAddress(){
        Set<Address> user = service2.getAll();
        return user;
    }
    @GetMapping(value = "/getall/dateAppointed", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<DateAppointed> getAllDateAppointed(){
        Set<DateAppointed> user = service3.getAll();
        return user;
    }
    @GetMapping(value = "/getall/userDemo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<UserDemography> getAllUserDemography(){
        Set<UserDemography> user = service4.getAll();
        return user;
    }
}
