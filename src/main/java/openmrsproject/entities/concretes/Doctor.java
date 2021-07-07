package openmrsproject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import openmrsproject.entities.abstracts.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "doctors")
public class Doctor extends User {

    @Column(name = "doctor_identity_num")
    private String doctorIdentityNum;

    @Column(name = "doctor_firstname")
    private String doctorFirstName;

    @Column(name = "doctor_lastname")
    private String doctorLastname;

    @Column(name = "doctor_gender")
    private char doctorGender;

    @Column(name = "doctor_phone")
    private String doctorPhone;

    @Column(name = "doctor_email")
    private String doctorEmail;

    @Column(name = "doctor_dateOfBirth")
    private LocalDate doctorDateOfBirth;

    @Column(name = "doctor_address")
    private String doctorAddress;

    @Column(name = "doctor_isRetired")
    private boolean doctorIsRetired;
}
