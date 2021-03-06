package openmrsproject.business.abstracts;

import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.entities.concretes.Doctor;
import openmrsproject.entities.concretes.Patient;

import java.net.DatagramPacket;
import java.util.List;

public interface DoctorService {
    DataResult<Doctor> add(Doctor doctor);
    DataResult<Doctor> getDoctorByIdentityNum(String identityNum);
    DataResult<List<Doctor>> getAllDoctors();
    DataResult<Doctor> updateDoctor(Doctor doctor);
}
