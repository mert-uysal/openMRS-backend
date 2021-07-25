package openmrsproject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class Appointment {
    @Id
    @SequenceGenerator(name ="appointment_id_gen_seq", sequenceName="appointment_id_gen_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_id_gen_seq")
    @Column(name = "appointment_id")
    private int id;

    @Column(name = "patient_identity_num")
    private String patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "doctor_identity_num")
    private String doctorId;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name ="appointment_date")
    private LocalDateTime appointmentDate;

    @Column(name="department")
    private String department;

    @Column(name= "appointment_status")
    private boolean appointmentStatus;

    @Column(name="create_date")
    private LocalDateTime createDate;

}
