package openmrsproject.api.controllers;

import openmrsproject.business.abstracts.VisitService;
import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.entities.abstracts.Visit;
import openmrsproject.entities.concretes.VisitInfoFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/visits")
@CrossOrigin
public class VisitsController {
    @Autowired
    private VisitService visitService;

    @PostMapping("/add")
    public DataResult<Visit> addVisit(@RequestBody Visit visit) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String tempDate = formatter.format(date);
        visit.setVisitCreateDate(LocalDateTime.parse(tempDate, formatter2));
        return this.visitService.add(visit);
    }

    @PostMapping("/delete")
    public void deleteVisit(@RequestBody Visit visit){
        this.visitService.delete(visit);
    }

    @PutMapping("/updateVisit")
    public DataResult<Visit> updateVisit(@RequestBody Visit visit){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String tempDate = formatter.format(date);
        visit.setVisitDate(LocalDateTime.parse(tempDate, formatter2));
        return this.visitService.updateVisit(visit);
    }

    @PostMapping("/getPatientVisitById")
    public DataResult<List<VisitInfoFull>> getPatientAllVisits(HttpServletRequest req) {
        return this.visitService.getPatientAllVisits(req.getParameter("id"));
    }

    @GetMapping("/getDoctorVisitById")
    public DataResult<List<VisitInfoFull>> getDoctorAllVisits(HttpServletRequest req) {
        return this.visitService.getDoctorAllVisits(req.getParameter("id"));
    }

    @GetMapping("/getAllActiveVisits")
    public DataResult<List<VisitInfoFull>> getAllActiveVisits(){
        return this.visitService.getAllActiveVisits();
    }

    @GetMapping("/getAllVisits")
    public DataResult<List<VisitInfoFull>> getAllVisits() {
        return this.visitService.getAllVisits();
    }

    @PostMapping("/getVisitById")
    public DataResult<Visit> getVisitById(@RequestParam Integer visitId) {
        return this.visitService.getVisitById(visitId);
    }
}
