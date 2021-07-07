package openmrsproject.api.controllers;

import openmrsproject.business.abstracts.DoctorService;
import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.entities.concretes.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.print.Doc;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin
public class DoctorsController {
    private DoctorService doctorService;

    @Autowired
    public DoctorsController(DoctorService doctorService) {
        super();
        this.doctorService = doctorService;
    }

    @GetMapping("/getById")
    DataResult<Doctor> getDoctorById(@RequestParam String id){
        return this.doctorService.getDoctorByIdentityNum(id);
    }

    @PostMapping("/addDoctor")
    DataResult<Doctor> addDoctor(@Valid @RequestBody Doctor doctor) {
        return this.doctorService.add(doctor);
    }
}
