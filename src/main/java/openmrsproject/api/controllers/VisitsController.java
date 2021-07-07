package openmrsproject.api.controllers;

import openmrsproject.business.abstracts.VisitService;
import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.entities.concretes.Patient;
import openmrsproject.entities.concretes.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
@CrossOrigin
public class VisitsController {
    @Autowired
    private VisitService visitService;

    @PostMapping("/add")
    public DataResult<Visit> addVisit(Visit visit) {
        return this.visitService.add(visit);
    }

    @PostMapping("/delete")
    public void deleteVisit(Visit visit){
        this.visitService.delete(visit);
    }

    @GetMapping("/getPatientVisitById")
    public DataResult<List<Visit>> getPatientAllVisits(String patientIdentityNum) {
        return this.visitService.getPatientAllVisits(patientIdentityNum);
    }

    @GetMapping("/getDoctorVisitById")
    public DataResult<List<Visit>> getDoctorAllVisits(String doctorIdentityNum) {
        return this.visitService.getDoctorAllVisits(doctorIdentityNum);
    }
}
