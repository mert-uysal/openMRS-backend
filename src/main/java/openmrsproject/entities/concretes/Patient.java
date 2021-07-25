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
@Table(name = "patients")
public class Patient {
    @Id
    @SequenceGenerator(name = "id_gen_seq", sequenceName = "id_gen_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen_seq")
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    @Column(name = "patient_id")
    private int id;

    @Column(name = "patient_identity_num")
    private String patientIdentityNum;

    @Column(name = "patient_firstname")
    private String patientFirstName;

    @Column(name = "patient_lastname")
    private String patientLastName;

    @Column(name = "patient_gender")
    private String patientGender;

    @Column(name = "patient_phone_num")
    private String patientPhoneNum;

    @Column(name = "patient_email")
    private String patientEmail;

    @Column(name = "patient_dateofbirth")
    private LocalDate patientDateOfBirt;

    @Column(name = "patient_address")
    private String patientAddress;

    @Column(name = "patient_familymember")
    private String patientFamilyMember;

    @Column(name = "patient_status")
    private String patientStatus;
}
