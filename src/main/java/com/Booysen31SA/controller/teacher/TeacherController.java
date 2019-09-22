package com.Booysen31SA.controller.teacher;

import com.Booysen31SA.domain.ResponseObj;
import com.Booysen31SA.domain.teacher.demography.Gender;
import com.Booysen31SA.domain.teacher.demography.Race;
import com.Booysen31SA.domain.teacher.user.User;
import com.Booysen31SA.domain.teacher.user.address.Address;
import com.Booysen31SA.domain.teacher.user.appointed.DateAppointed;
import com.Booysen31SA.domain.teacher.user.userDemography.UserDemography;
import com.Booysen31SA.factory.ResponseObjFactory;
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
        if(id.equalsIgnoreCase("1")){
            return "Correct ID";
        }else{
            return "Wrong";
        }
    }

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserServiceImpl service;
    private AddressServiceImpl service2;
    private AppointedServiceImpl service3;
    private UserDemographyServiceImpl service4;
    private GenderService service5;
    private RaceService service6;


    @PostMapping(value = "/create/{persalNumber}/{id}/{firstName}/{LastName}/{gender}/{race}/{DateAppointed}/{address}/{postalAddress}")
    public ResponseEntity create(@PathVariable String persalNumber, @PathVariable String firstName,
                                 @PathVariable String LastName, @PathVariable long id, @PathVariable String gender,
                                 @PathVariable String race, @PathVariable String appointed,
                                 @PathVariable String address, @PathVariable String postalAddress){

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Teacher created!");
        User app = service.read(persalNumber.trim());
        Address dat = service2.read(persalNumber.trim());
        DateAppointed appoint = service3.read(persalNumber.trim());
        UserDemography ud = service4.read(persalNumber.trim());
        Gender g = service5.getByName(gender);
        Race r = service6.getByName(race);

        if(app == null){
            responseObj.setResponseDescription("User already exist!");
        }else{
            User app2 = UserFactory.buildUser(persalNumber, id, firstName, LastName);
            Address dat2 = AddressFactory.buildAddress(persalNumber, address, postalAddress);
            DateAppointed ap2= DateAppointedFactory.buildDateAppointed(persalNumber, appointed);
            UserDemography demo = UserDemographyFactory.buildUserDemography(persalNumber, g.getGenderId(), r.getRaceId());

            service.create(app2);
            service2.create(dat2);
            service3.create(ap2);
            service4.create(demo);
        }
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping(value = "/update/{persalNumber}/{id}/{firstName}/{LastName}/{gender}/{race}/{DateAppointed}/{address}/{postalAddress}")
    public ResponseEntity update(@PathVariable String persalNumber, @PathVariable String firstName,
                                 @PathVariable String LastName, @PathVariable long id, @PathVariable String gender,
                                 @PathVariable String race, @PathVariable String appointed,
                                 @PathVariable String address, @PathVariable String postalAddress){

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Teacher updated!");
        User app = service.read(persalNumber.trim());
        Address dat = service2.read(persalNumber.trim());
        DateAppointed appoint2 = service3.read(persalNumber.trim());
        UserDemography ud2 = service4.read(persalNumber.trim());
        Gender g = service5.getByName(gender);
        Race r = service6.getByName(race);

        if(app != null){
            responseObj.setResponseDescription("User Dont exist!");
        }else{
            User app2 = UserFactory.buildUser(persalNumber, id, firstName, LastName);
            Address dat2 = AddressFactory.buildAddress(persalNumber, address, postalAddress);
            DateAppointed ap2= DateAppointedFactory.buildDateAppointed(persalNumber, appointed);
            UserDemography demo = UserDemographyFactory.buildUserDemography(persalNumber, g.getGenderId(), r.getRaceId());

            service.update(app2);
            service2.update(dat2);
            service3.update(ap2);
            service4.update(demo);
        }
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping("/delete/{persalNumber}")
    public ResponseEntity delete(@PathVariable String persalNumber){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "User Delete!");
        User app = service.read(persalNumber.trim());
        if(app == null){
            responseObj.setResponseDescription("User Dont exist!");
        }else{
            service.delete(persalNumber);
        }
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping("/read/{persalNumber}")
    public ResponseEntity read(@PathVariable String persalNumber){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "User created!");
        User app = service.read(persalNumber.trim());
        if(app == null){
            responseObj.setResponseDescription("User Dont exist!");
        }else{
            app = service.read(persalNumber);
        }
        return ResponseEntity.ok(app);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<User> getAll() {
        return service.getAll();
    }
}
