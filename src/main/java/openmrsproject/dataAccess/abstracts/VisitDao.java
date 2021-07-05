package openmrsproject.dataAccess.abstracts;

import openmrsproject.entities.concretes.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitDao extends JpaRepository<Visit, Integer> {

}
