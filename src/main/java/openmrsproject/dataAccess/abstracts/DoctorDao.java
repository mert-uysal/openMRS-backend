package openmrsproject.dataAccess.abstracts;

import openmrsproject.entities.concretes.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorDao extends JpaRepository<Doctor, Integer> {
}
