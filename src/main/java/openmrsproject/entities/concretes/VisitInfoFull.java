package openmrsproject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import openmrsproject.entities.abstracts.Visit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visit_full_info")
public class VisitInfoFull extends Visit {
    @Column(name = "patient_firstname")
    private String patientFirstName;

    @Column(name = "patient_lastname")
    private String patientLastName;

    @Column(name = "doctor_firstname")
    private String doctorFirstName;

    @Column(name = "doctor_lastname")
    private String doctorLastName;
}
