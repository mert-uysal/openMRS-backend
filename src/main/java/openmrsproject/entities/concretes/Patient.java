package openmrsproject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import openmrsproject.entities.abstracts.User;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Patient extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="patient_identity_num")
    private String patientIdentityNum;

    @Column(name = "patient_firstname")
    private String patientFirstName;

    @Column(name = "patient_lastname")
    private String patientLastName;

    @Column(name = "patient_familyMember")
    private String patientFamilyMember;

    @Column(name = "patient_gender")
    private char patientGender;

    @Column(name = "patient_phone_num")
    private String patientPhoneNum;

    @Column(name = "patient_email")
    private String patientEmail;

    @Column(name = "patient_dateOfBirth")
    private LocalDate patientDateOfBirt;

    @Column(name = "patient_address")
    private String patientAddress;
}
