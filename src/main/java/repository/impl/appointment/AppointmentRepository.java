package repository.impl.appointment;

import domain.appointment.Apointment;
import repository.IRepository;

import java.util.Set;

public interface AppointmentRepository extends IRepository<Apointment, Integer> {
    Set<Apointment> getAll();
}
