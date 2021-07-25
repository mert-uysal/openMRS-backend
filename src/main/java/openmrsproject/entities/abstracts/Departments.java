package openmrsproject.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments")
public class Departments {
    @Id
    @SequenceGenerator(name ="department_id_gen_seq", sequenceName="department_id_gen_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_id_gen_seq")
    @Column(name = "department_id")
    private int id;

    @Column(name = "department_name")
    private String departmentName;
}
