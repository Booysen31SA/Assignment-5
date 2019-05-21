package com.Booysen31SA.services.impl.appointment;

import com.Booysen31SA.domain.appointment.Appointment;
import com.Booysen31SA.repository.impl.appointment.AppointmentRepository;
import com.Booysen31SA.repository.impl.appointment.AppointmentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("AppointmentServiceImpl")
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentServiceImpl services = null;
    private AppointmentRepository repository;

    public AppointmentServiceImpl(){this.repository = AppointmentRepositoryImpl.getAppointment();
    }

    public AppointmentServiceImpl getServices(){if(services == null) services = new AppointmentServiceImpl();
    return services;}

    @Override
    public Set<Appointment> getAll() {
        return repository.getAll();
    }

    @Override
    public Appointment create(Appointment appointment) {
        return repository.create(appointment);
    }

    @Override
    public Appointment update(Appointment appointment) {
       return repository.update(appointment);
    }

    @Override
    public void delete(Integer integer) {
      repository.delete(integer);
    }

    @Override
    public Appointment read(Integer integer) {
        return repository.read(integer);
    }
}
