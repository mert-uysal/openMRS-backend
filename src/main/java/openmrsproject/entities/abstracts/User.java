package openmrsproject.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name="users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;

    @Column(name = "user_identity_num")
    private String userIdentityNum;

    @Column(name="user_password")
    private String userPassword;

    @Column(name="register_date")
    private LocalDate registerDate;

}
