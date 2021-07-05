package openmrsproject.dataAccess.abstracts;

import openmrsproject.entities.abstracts.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
