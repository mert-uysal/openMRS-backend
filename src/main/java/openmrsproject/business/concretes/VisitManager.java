package openmrsproject.business.concretes;

import openmrsproject.business.abstracts.VisitService;
import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.core.utilities.results.SuccessDataResult;
import openmrsproject.dataAccess.abstracts.VisitDao;
import openmrsproject.entities.concretes.Patient;
import openmrsproject.entities.concretes.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitManager implements VisitService {
    private VisitDao visitDao;

    @Override
    public DataResult<Visit> add(Visit visit) {
        return new SuccessDataResult<Visit>(this.visitDao.save(visit), "Visit Ekleme Başarılı");
    }

    @Override
    public void delete(Visit visit) {
        this.visitDao.deleteById(visit.getId());
    }

    @Override
    public DataResult<List<Visit>> getPatientAllVisits(String patientId) {
        return new SuccessDataResult<List<Visit>>(this.visitDao.getByPatientId(patientId),"Hastanın Tüm Visitleri Listelendi");
    }

    @Override
    public DataResult<List<Visit>> getDoctorAllVisits(String doctorId) {
        return new SuccessDataResult<List<Visit>>(this.visitDao.getByDoctorId(doctorId),"Doktorun Tüm Visitleri Listelendi");
    }
}
