package openmrsproject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import openmrsproject.entities.abstracts.User;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "doctors")
@PrimaryKeyJoinColumn(name = "doctor_Id")
public class Doctor extends User {

    @Column(name = "doctor_identity_num")
    private String doctorIdentityNum;

    @Column(name = "doctor_firstname")
    private String doctorFirstName;

    @Column(name = "doctor_lastname")
    private String doctorLastName;

    @Column(name = "doctor_gender")
    private char doctorGender;

    @Column(name = "doctor_phone")
    private String doctorPhone;

    @Column(name = "doctor_email")
    private String doctorEmail;

    @Column(name = "doctor_dateofbirth")
    private LocalDate doctorDateOfBirth;

    @Column(name = "doctor_address")
    private String doctorAddress;

    @Column(name = "doctor_isretired")
    private boolean doctorIsRetired;
}
