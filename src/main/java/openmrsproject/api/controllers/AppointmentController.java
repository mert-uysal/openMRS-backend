package openmrsproject.api.controllers;

import openmrsproject.business.abstracts.AppointmentService;
import openmrsproject.business.concretes.AppointmentManager;
import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.dataAccess.abstracts.DepartmentsDao;
import openmrsproject.entities.abstracts.Departments;
import openmrsproject.entities.abstracts.Visit;
import openmrsproject.entities.concretes.Appointment;
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
@RequestMapping("/api/appointments")
@CrossOrigin
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private DepartmentsDao departmentsDao;

    @PostMapping("/add")
    public DataResult<Appointment> addAppointment(@RequestBody Appointment appointment) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String tempDate = formatter.format(date);
        appointment.setCreateDate(LocalDateTime.parse(tempDate, formatter2));
        return this.appointmentService.add(appointment);
    }

    @PostMapping("/delete")
    public void deleteAppointment(@RequestBody Appointment appointment){
        this.appointmentService.delete(appointment);
    }

    @PostMapping("/updateAppointment")
    public DataResult<Appointment> updateAppointment(@RequestBody Appointment appointment) {
        return this.appointmentService.updateAppointment(appointment);
    }

    @PostMapping("/getPatientAppointmentById")
    public DataResult<List<Appointment>> getPatientAllAppointments (HttpServletRequest req) {
        return this.appointmentService.getPatientAllAppointments(req.getParameter("id"));
    }

    @PostMapping("/getDoctorAppointmentById")
    public DataResult<List<Appointment>> getDoctorAllAppointments (HttpServletRequest req) {
        return this.appointmentService.getDoctorAllAppointments(req.getParameter("id"));
    }

    @GetMapping("/getAllActiveAppointments")
    public DataResult<List<Appointment>> getAllActiveAppointments () {
        return this.appointmentService.getAllActiveAppointments();
    }

    @GetMapping("/getAllAppointments")
    public DataResult<List<Appointment>> getAllAppointments () {
        return this.appointmentService.getAllAppointments();
    }

    @PostMapping("/getAppointmentsByDate")
    public DataResult<List<Appointment>> getAppointmentsByDate(LocalDateTime date) {
        return this.appointmentService.getAppointmentByDate(date);
    }

    @GetMapping("/getDepartments")
    public List<Departments> getDepartments() {
        return this.departmentsDao.findAll();
    }
}
