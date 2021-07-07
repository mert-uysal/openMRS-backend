package openmrsproject.business.concretes;

import openmrsproject.business.abstracts.DoctorService;
import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.core.utilities.results.SuccessDataResult;
import openmrsproject.dataAccess.abstracts.DoctorDao;
import openmrsproject.dataAccess.abstracts.UserDao;
import openmrsproject.entities.abstracts.User;
import openmrsproject.entities.concretes.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorManager implements DoctorService {
    private DoctorDao doctorDao;
    private UserDao userDao;

    @Override
    public DataResult<Doctor> add(Doctor doctor) {
        User user = new User(doctor.getId(), doctor.getUserIdentityNum(), doctor.getUsername(),
                doctor.getUserPassword(), doctor.getRegisterDate());
        this.userDao.save(user);
        return new SuccessDataResult<Doctor>(this.doctorDao.save(doctor), "Doktor Eklendi.");
    }

    @Override
    public DataResult<Doctor> getDoctorByIdentityNum(String identityNum) {
        return new SuccessDataResult<Doctor>(this.doctorDao.getDoctorByDoctorIdentityNum(identityNum));
    }
}
