package openmrsproject.dataAccess.abstracts;

import openmrsproject.entities.concretes.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment,Integer> {
    List<Appointment> getByPatientId(String patientId);
    List<Appointment> getByDoctorId(String doctorId);
    List<Appointment> findAllByAppointmentStatusIsTrue();
    List<Appointment> findAllByAppointmentDate(LocalDateTime date);
}
