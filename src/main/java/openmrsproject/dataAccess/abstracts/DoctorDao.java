package openmrsproject.dataAccess.abstracts;

import openmrsproject.entities.concretes.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Integer> {
    Doctor getDoctorByDoctorIdentityNum(String identityNum);
}
