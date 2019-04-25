package repository.impl.appointment;

import domain.appointment.Apointment;

import java.util.HashSet;
import java.util.Set;

public class AppointmentRepositoryImpl implements AppointmentRepository {

    private static AppointmentRepositoryImpl repository = null;
    private Set<Apointment> appointment;

    private AppointmentRepositoryImpl(){
        this.appointment = new HashSet<>();
    }

    public static AppointmentRepositoryImpl getAppointment(){
        if(repository == null) repository = new AppointmentRepositoryImpl();
        return repository;
    }
    @Override
    public Set<Apointment> getAll() {
        return appointment;
    }

    @Override
    public Apointment create(Apointment apointment) {
        this.appointment.add(apointment);
        return apointment;
    }

    @Override
    public Apointment update(Apointment apointment) {
        Apointment find = search(apointment.getPersalNumber());
        if(appointment.contains(find)){
            appointment.remove(find);
            appointment.add(apointment);
        }
        return apointment;
    }

    @Override
    public void delete(Integer id) {
      appointment.remove(search(id));
    }

    @Override
    public Apointment read(Integer id) {
        return search(id);
    }

    public Apointment search(Integer id){
        return appointment.stream().filter(apointment -> apointment.getPersalNumber() == id).findAny().orElse(null);
    }
}
