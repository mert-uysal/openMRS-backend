package openmrsproject.business.concretes;

import openmrsproject.business.abstracts.AppointmentService;
import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.core.utilities.results.Result;
import openmrsproject.core.utilities.results.SuccessDataResult;
import openmrsproject.core.utilities.results.SuccessResult;
import openmrsproject.dataAccess.abstracts.AppointmentDao;
import openmrsproject.entities.concretes.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentManager implements AppointmentService {
    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    public DataResult<Appointment> add(Appointment appointment) {
        return new SuccessDataResult<Appointment>(this.appointmentDao.save(appointment), "Randevu Başarılı.");
    }

    @Override
    public Result delete(Appointment appointment) {
        this.appointmentDao.deleteById(appointment.getId());
        return new SuccessResult(true,"Randevu Silindi.");
    }

    @Override
    public DataResult<Appointment> updateAppointment(Appointment appointment) {
        return new SuccessDataResult<Appointment>(this.appointmentDao.save(appointment),"Randevu Güncellendi.");
    }

    @Override
    public DataResult<List<Appointment>> getPatientAllAppointments(String patientId) {
        return new SuccessDataResult<List<Appointment>>(this.appointmentDao.getByPatientId(patientId), "Hastanın Tüm Randevuları Görüntülendi.");
    }

    @Override
    public DataResult<List<Appointment>> getDoctorAllAppointments(String doctorId) {
        return new SuccessDataResult<List<Appointment>>(this.appointmentDao.getByDoctorId(doctorId), "Doktorun Tüm Randevuları Görüntülendi.");
    }

    @Override
    public DataResult<List<Appointment>> getAllActiveAppointments() {
        return new SuccessDataResult<List<Appointment>>(this.appointmentDao.findAllByAppointmentStatusIsTrue(),"Aktif Randevular Listelendi.");
    }

    @Override
    public DataResult<List<Appointment>> getAllAppointments() {
        return new SuccessDataResult<List<Appointment>>(this.appointmentDao.findAll(), "Tüm Randevular Listelendi.");
    }

    @Override
    public DataResult<List<Appointment>> getAppointmentByDate(LocalDateTime date) {
        return new SuccessDataResult<List<Appointment>>(this.appointmentDao.findAllByAppointmentDate(date), "Seçilen Randevu Görüntülendi.");
    }

}
