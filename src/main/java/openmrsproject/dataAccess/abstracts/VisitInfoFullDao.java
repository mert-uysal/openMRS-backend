package openmrsproject.dataAccess.abstracts;

import openmrsproject.entities.concretes.VisitInfoFull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitInfoFullDao extends JpaRepository<VisitInfoFull, Integer> {
    List<VisitInfoFull> getByPatientId(String patientId);
    List<VisitInfoFull> getByDoctorId(String doctorId);
    List<VisitInfoFull> findAllByVisitStatusIsTrue();
}
