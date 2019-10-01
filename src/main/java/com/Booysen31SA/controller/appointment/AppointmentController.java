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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

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
        @Qualifier("AppointmentServiceImpl")
        private AppointmentServiceImpl service;
        @Qualifier("DateAndTimeServiceImpl")
        private DateAndTimeServiceImpl service2;
        @Qualifier("ReasonServiceImpl")
        private ReasonServiceImpl service3;

        @PostMapping(value = "/create")
        public ResponseEntity createA( @RequestBody AppointmentCreation appointmentCreation){
            service2 = DateAndTimeServiceImpl.getService();
            service3 = ReasonServiceImpl.getService();
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
            return ResponseEntity.ok(responseObj);

        }
    }
