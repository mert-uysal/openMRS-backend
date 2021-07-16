package openmrsproject.dataAccess.abstracts;

import openmrsproject.entities.abstracts.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitDao extends JpaRepository<Visit, Integer> {
    Visit getVisitById(Integer visitId);
}
