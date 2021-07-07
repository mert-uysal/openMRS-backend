package openmrsproject.dataAccess.abstracts;

import openmrsproject.entities.abstracts.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao extends JpaRepository<User, Integer> {
    User findUserByUsername (String username);
    boolean existsUserByUsername (String username);
    /*@Modifying
    @Query(value = "select count(u) > 0 from User u where u.username = ?1", nativeQuery = true)
    boolean isUsernameExist(String username);*/
}
