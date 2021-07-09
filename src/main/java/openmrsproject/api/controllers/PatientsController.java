package openmrsproject.api.controllers;

import openmrsproject.business.abstracts.PatientService;
import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.entities.concretes.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin
public class PatientsController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/add")
    public DataResult<Patient> addPatient(@RequestBody Patient patient) {
        return this.patientService.add(patient);
    }

    @PostMapping("/delete")
    public void deletePatient(@RequestParam Patient patient){
        this.patientService.delete(patient);
    }

    @GetMapping("/getById")
    public DataResult<Patient> getPatientByIdentityNum(@RequestParam String identityNum) {
        return this.patientService.getPatientByIdentityNum(identityNum);
    }

    @GetMapping("/getAllPatients")
    public DataResult<List<Patient>> getAllPatients(){
        return this.patientService.getAllPatient();
    }
}
