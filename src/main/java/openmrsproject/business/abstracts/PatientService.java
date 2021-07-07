package openmrsproject.business.abstracts;

import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.core.utilities.results.Result;
import openmrsproject.entities.concretes.Patient;

import java.util.List;

public interface PatientService {
    DataResult<Patient> add(Patient patient);
    void delete(Patient patient);
    DataResult<Patient> getPatientByIdentityNum(String identityNum);
    DataResult<List<Patient>> getAllPatient();
}
