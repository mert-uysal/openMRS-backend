package openmrsproject.business.concretes;

import openmrsproject.business.abstracts.PatientService;
import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.core.utilities.results.Result;
import openmrsproject.core.utilities.results.SuccessDataResult;
import openmrsproject.core.utilities.results.SuccessResult;
import openmrsproject.dataAccess.abstracts.PatientDao;
import openmrsproject.entities.concretes.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientManager implements PatientService {
    private PatientDao patientDao;

    @Override
    public DataResult<Patient> add(Patient patient) {
        return new SuccessDataResult<Patient>(this.patientDao.save(patient), "Hasta Kaydı Başarılı.");
    }

    @Override
    public void delete(Patient patient) {
        this.patientDao.deleteById(patient.getId());
    }

    @Override
    public DataResult<Patient> getPatientByIdentityNum(String identityNum) {
        return new SuccessDataResult<Patient>(this.patientDao.getPatientByPatientIdentityNum(identityNum), "Hasta Görüntüleme Başarılı.");
    }

    @Override
    public DataResult<List<Patient>> getAllPatient() {
        return new SuccessDataResult<List<Patient>>(this.patientDao.findAll(),"Tüm Hastalar Görünülendi.");
    }
}
