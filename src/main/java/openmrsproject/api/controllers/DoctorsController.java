package openmrsproject.api.controllers;

import openmrsproject.business.abstracts.DoctorService;
import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.entities.concretes.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.print.Doc;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String tempDate = formatter.format(date);
        doctor.setRegisterDate(LocalDateTime.parse(tempDate, formatter2));
        return this.doctorService.add(doctor);
    }
}
