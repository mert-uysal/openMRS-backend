package openmrsproject.dataAccess.abstracts;

import openmrsproject.entities.concretes.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitDao extends JpaRepository<Visit, Integer> {
    List<Visit> getByPatientId(String patientId);
    List<Visit> getByDoctorId(String doctorId);
}
