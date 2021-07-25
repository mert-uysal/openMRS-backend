package openmrsproject.business.abstracts;

import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.core.utilities.results.Result;
import openmrsproject.entities.concretes.Appointment;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
    DataResult<Appointment> add(Appointment appointment);
    Result delete(Appointment appointment);
    DataResult<Appointment> updateAppointment(Appointment appointment);
    DataResult<List<Appointment>> getPatientAllAppointments(String patientId);
    DataResult<List<Appointment>> getDoctorAllAppointments(String doctorId);
    DataResult<List<Appointment>> getAllActiveAppointments();
    DataResult<List<Appointment>> getAllAppointments();
    DataResult<List<Appointment>> getAppointmentByDate(LocalDateTime date);
}
