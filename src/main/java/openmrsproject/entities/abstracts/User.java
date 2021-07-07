package openmrsproject.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;

    @Column(name = "user_identity_num")
    private String userIdentityNum;

    @Column(name = "user_username")
    private String username;

    @Column(name="user_password")
    private String userPassword;

    @Column(name="user_register_date")
    private LocalDate registerDate;

}
