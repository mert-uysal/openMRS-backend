package openmrsproject.business.concretes;

import openmrsproject.business.abstracts.PatientService;
import openmrsproject.core.utilities.results.*;
import openmrsproject.dataAccess.abstracts.PatientDao;
import openmrsproject.entities.concretes.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientManager implements PatientService {
    @Autowired
    private PatientDao patientDao;

    @Override
    public DataResult<Patient> add(Patient patient) {
        return new SuccessDataResult<Patient>(this.patientDao.save(patient), "Hasta Kaydı Başarılı.");
    }

    @Override
    public void delete(Patient patient) {
        this.patientDao.deleteById(patient.getId());
        //new SuccessResult(true, "Hasta Silindi.");
    }

    @Override
    public DataResult<Patient> updatePatient(Patient patient) {
        return new SuccessDataResult<Patient>(this.patientDao.save(patient), "Hasta Güncellendi.");
    }

    @Override
    public DataResult<Patient> getPatientByIdentityNum(String identityNum) {
        Patient patient = this.patientDao.findPatientByPatientIdentityNum(identityNum);
        if (patient != null)
            return new SuccessDataResult<Patient>(patient, "Hasta Görüntüleme Başarılı.");
        else
            return new ErrorDataResult<Patient>(patient, "Hasta görüntüleme Başarısız");
    }

    @Override
    public DataResult<List<Patient>> getAllPatient() {
        return new SuccessDataResult<List<Patient>>(this.patientDao.findAll(), "Tüm Hastalar Görüntülendi.");
    }

    @Override
    public DataResult<List<Patient>> getAllinPatient(String patientStatus) {
        return new SuccessDataResult<List<Patient>>(this.patientDao.getAllByPatientStatusEquals(patientStatus), "Tüm Yatan Hastalar Görüntülendi.");
    }

    @Override
    public DataResult<List<Patient>> getAllOutPatient(String patientStatus) {
        return new SuccessDataResult<List<Patient>>(this.patientDao.getAllByPatientStatusEquals(patientStatus), "Tüm Ayakta Tedavi Hastaları Görüntülendi.");
    }
}
