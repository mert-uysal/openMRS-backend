package openmrsproject.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @SequenceGenerator(name ="user_id_gen_seq", sequenceName="user_id_gen_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_gen_seq")
    @Column(name="user_id")
    private int id;

    @Column(name = "user_identity_num")
    private String userIdentityNum;

    @Column(name = "user_username")
    private String username;

    @Column(name="user_password")
    private String userPassword;

    @Column(name="user_register_date")
    private LocalDateTime registerDate;
}
