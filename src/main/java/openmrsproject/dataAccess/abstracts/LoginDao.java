package openmrsproject.dataAccess.abstracts;

import openmrsproject.entities.abstracts.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDao extends JpaRepository<User, Integer> {
}
