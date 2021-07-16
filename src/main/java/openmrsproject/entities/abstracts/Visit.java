package openmrsproject.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visits")
@Inheritance(strategy = InheritanceType.JOINED)
public class Visit {

    @Id
    @SequenceGenerator(name ="visit_id_gen_seq", sequenceName="visit_id_gen_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visit_id_gen_seq")
    @Column(name = "visit_id")
    private int id;

    @Column(name = "patient_identity_num")
    private String patientId;

    @Column(name = "doctor_identity_num")
    private String doctorId;

    @Column(name = "visit_date")
    private LocalDateTime visitDate;

    @Column(name = "visit_description")
    private String visitDescription;

    @Column(name= "visit_status")
    private boolean visitStatus;

    @Column(name = "visit_create_date")
    private LocalDateTime visitCreateDate;
}
