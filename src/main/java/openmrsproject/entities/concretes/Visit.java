package openmrsproject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_id")
    private int id;

    @Column(name = "patient_identity_num")
    private String patientId;

    @Column(name = "doctor_identity_num")
    private String doctorId;

    @Column(name = "visit_date")
    private LocalDate visitDate;

    @Column(name = "visit_description")
    private String visitDescription;
}
