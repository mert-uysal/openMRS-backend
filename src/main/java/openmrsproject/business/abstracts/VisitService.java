package openmrsproject.business.abstracts;

import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.entities.abstracts.Visit;
import openmrsproject.entities.concretes.VisitInfoFull;

import java.util.List;

public interface VisitService {
    DataResult<Visit> add(Visit visit);
    void delete(Visit visit);
    DataResult<List<VisitInfoFull>> getPatientAllVisits(String patientId);
    DataResult<List<VisitInfoFull>> getDoctorAllVisits(String doctorId);
    DataResult<List<VisitInfoFull>> getAllActiveVisits();
    DataResult<List<VisitInfoFull>> getAllVisits();
    DataResult<Visit> getVisitById(Integer visitId);
    DataResult<Visit> updateVisit(Visit visit);
}
