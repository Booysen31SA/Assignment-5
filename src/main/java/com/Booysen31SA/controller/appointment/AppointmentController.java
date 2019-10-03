package com.Booysen31SA.controller.appointment;

import com.Booysen31SA.domain.ResponseObj;
import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.domain.appointment.DateAndTime;
import com.Booysen31SA.domain.appointment.Reason;
import com.Booysen31SA.factory.ResponseObjFactory;
import com.Booysen31SA.factory.appointment.AppointmentFactory;
import com.Booysen31SA.factory.appointment.DateAndTimeFactory;
import com.Booysen31SA.factory.appointment.ReasonFactory;
import com.Booysen31SA.services.appointment.impl.AppointmentServiceImpl;
import com.Booysen31SA.services.appointment.impl.DateAndTimeServiceImpl;
import com.Booysen31SA.services.appointment.impl.ReasonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    @Qualifier("AppointmentServiceImpl")
    private AppointmentServiceImpl service;
    @Autowired
    @Qualifier("DateAndTimeServiceImpl")
    private DateAndTimeServiceImpl service2;
    @Autowired
    @Qualifier("ReasonServiceImpl")
    private ReasonServiceImpl service3;

    public AppointmentController() {
        service = AppointmentServiceImpl.getService();
        service2  = DateAndTimeServiceImpl.getService();
        service3 = ReasonServiceImpl.getService();
    }

    @GetMapping("/test/{id}")
        @ResponseBody
        public String test(@PathVariable String id) {
            if(id.equalsIgnoreCase("1")){
                return "Correct ID";
            }else{
                return "Wrong";
            }
        }

        @PostMapping(value = "/create")
        public AppointmentCreation createA( @RequestBody AppointmentCreation appointmentCreation){

            ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Appointment created!");

            Appointment appointment = appointmentCreation.getAppointment();
            DateAndTime dateAndTime = appointmentCreation.getDateAndTime();
            Reason reason = appointmentCreation.getReason();

            DateAndTime dateAndTime1;
            Appointment appointment1;
            Reason reason1;
            if (appointment == null) {
                responseObj.setResponse(appointmentCreation);
                responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
                responseObj.setResponseDescription("Provide an appointment!");
            }else{

                    appointment1 = AppointmentFactory.buildAppointment(appointment.getPersalNumber(), appointment.getAppointmentToSee());
                    dateAndTime1 = DateAndTimeFactory.buildDateAndTime(appointment.getPersalNumber(), dateAndTime.getDate(), dateAndTime.getTime());
                    reason1 = ReasonFactory.buildReason(appointment.getPersalNumber(), reason.getReason());

                    service.create(appointment1);
                    service2.create(dateAndTime1);
                    service3.create(reason1);

                responseObj.setResponse(appointmentCreation);
            }
            return new AppointmentCreation(appointmentCreation.getAppointment(), appointmentCreation.getDateAndTime(), appointmentCreation.getReason());

        }

        @GetMapping(value = "/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AppointmentCreation read(@PathVariable String id){

            ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Get Appointment!");

            Appointment appointment = service.read(id);
            DateAndTime dateAndTime = service2.read(id);
            Reason reason = service3.read(id);
            AppointmentCreation appointmentCreation = new AppointmentCreation(appointment, dateAndTime, reason);

            return new AppointmentCreation(appointmentCreation.getAppointment(), appointmentCreation.getDateAndTime(), appointmentCreation.getReason());
        }

    @PostMapping(value = "/update")
    public AppointmentCreation update( @RequestBody AppointmentCreation appointmentCreation){

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Appointment updated!");

        Appointment appointment = appointmentCreation.getAppointment();
        DateAndTime dateAndTime = appointmentCreation.getDateAndTime();
        Reason reason = appointmentCreation.getReason();

        DateAndTime dateAndTime1;
        Appointment appointment1;
        Reason reason1;

        Appointment appointment2 = service.read(appointment.getPersalNumber());

        if (appointment2 == null) {
            responseObj.setResponse(appointmentCreation);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Appointment dont exist!");
        }else{

            appointment1 = AppointmentFactory.buildAppointment(appointment.getPersalNumber(), appointment.getAppointmentToSee());
            dateAndTime1 = DateAndTimeFactory.buildDateAndTime(appointment.getPersalNumber(), dateAndTime.getDate(), dateAndTime.getTime());
            reason1 = ReasonFactory.buildReason(appointment.getPersalNumber(), reason.getReason());

            service.update(appointment1);
            service2.update(dateAndTime1);
            service3.update(reason1);

            responseObj.setResponse(appointmentCreation);
        }
        return new AppointmentCreation(appointmentCreation.getAppointment(), appointmentCreation.getDateAndTime(), appointmentCreation.getReason());

    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AppointmentCreation delete(@PathVariable String id){

        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Deleted Appointment!");

        Appointment appointment = service.read(id);
        DateAndTime dateAndTime = service2.read(id);
        Reason reason = service3.read(id);
        AppointmentCreation appointmentCreation = new AppointmentCreation();
        if(appointment == null){
            responseObj.setResponse(id);
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("appointment Doesnt exist!");
        }else{
            AppointmentCreation appointmentCreationUpdated = new AppointmentCreation(appointment, dateAndTime, reason);

            service.delete(appointment.getPersalNumber());
            service2.delete(dateAndTime.getPersal_Number());
            service3.delete(reason.getPersal_Number());
            responseObj.setResponse(appointmentCreation);
        }
        return new AppointmentCreation(appointmentCreation.getAppointment(), appointmentCreation.getDateAndTime(), appointmentCreation.getReason());
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Set<Appointment> genders = service.getAll();
        responseObj.setResponse(genders);
        return ResponseEntity.ok(responseObj);
    }
    }
