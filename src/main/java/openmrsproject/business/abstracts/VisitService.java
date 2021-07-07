package openmrsproject.business.abstracts;

import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.entities.concretes.Patient;
import openmrsproject.entities.concretes.Visit;

import java.util.List;

public interface VisitService {
    DataResult<Visit> add(Visit visit);
    void delete(Visit visit);
    DataResult<List<Visit>> getPatientAllVisits(String patientId);
    DataResult<List<Visit>> getDoctorAllVisits(String doctorId);
}
