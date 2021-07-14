package openmrsproject.dataAccess.abstracts;

import openmrsproject.entities.concretes.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDao extends JpaRepository<Patient, Integer> {
    //@Query("select p from Patient p where p.patientIdentityNum = ?1")
    //Patient getByidentityNumber(@Param("identityNumber") String identityNumber);
    Patient findPatientByPatientIdentityNum(String identityNumber);
}
