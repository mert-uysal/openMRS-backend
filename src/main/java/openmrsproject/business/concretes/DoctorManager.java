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

import java.util.List;

@Service
public class DoctorManager implements DoctorService {
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private UserDao userDao;

    @Override
    public DataResult<Doctor> add(Doctor doctor) {
        return new SuccessDataResult<Doctor>(this.doctorDao.save(doctor), "Doktor Kaydı Başarılı.");
    }

    @Override
    public DataResult<Doctor> getDoctorByIdentityNum(String identityNum) {
        return new SuccessDataResult<Doctor>(this.doctorDao.getDoctorByDoctorIdentityNum(identityNum),"Doktor Bilgisi Görüntülendi.");
    }

    @Override
    public DataResult<List<Doctor>> getAllDoctors() {
        return new SuccessDataResult<List<Doctor>>(this.doctorDao.findAll(), "Tüm Doktorlar Listelendi.");
    }
}
