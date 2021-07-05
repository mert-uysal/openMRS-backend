package openmrsproject.dataAccess.abstracts;

import openmrsproject.entities.concretes.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDao extends JpaRepository<Patient, Integer> {
    Patient getByidentityNumber(String identityNumber);
}
