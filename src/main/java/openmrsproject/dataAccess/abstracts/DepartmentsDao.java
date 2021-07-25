package openmrsproject.dataAccess.abstracts;

import openmrsproject.entities.abstracts.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsDao extends JpaRepository<Departments, Integer> {
}
