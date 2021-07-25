package openmrsproject.business.concretes;

import openmrsproject.business.abstracts.VisitService;
import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.core.utilities.results.SuccessDataResult;
import openmrsproject.dataAccess.abstracts.VisitDao;
import openmrsproject.dataAccess.abstracts.VisitInfoFullDao;
import openmrsproject.entities.abstracts.Visit;
import openmrsproject.entities.concretes.VisitInfoFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitManager implements VisitService {
    @Autowired
    private VisitDao visitDao;
    @Autowired
    private VisitInfoFullDao visitInfoFullDao;

    @Override
    public DataResult<Visit> add(Visit visit) {
        return new SuccessDataResult<Visit>(this.visitDao.save(visit), "Visit Ekleme Başarılı");
    }

    @Override
    public void delete(Visit visit) {
        this.visitDao.deleteById(visit.getId());
    }

    @Override
    public DataResult<Visit> updateVisit(Visit visit) {
        Visit updatedVisit = this.visitDao.getVisitById(visit.getId());
        updatedVisit.setVisitDate(visit.getVisitDate());
        updatedVisit.setVisitDescription(visit.getVisitDescription());
        updatedVisit.setVisitStatus(visit.isVisitStatus());
        return new SuccessDataResult<Visit>(this.visitDao.save(updatedVisit), "Visit Güncellendi.");
    }

    @Override
    public DataResult<List<VisitInfoFull>> getPatientAllVisits(String patientId) {
        return new SuccessDataResult<List<VisitInfoFull>>(this.visitInfoFullDao.getByPatientId(patientId), "Hastanın Tüm Visitleri Listelendi");
    }

    @Override
    public DataResult<List<VisitInfoFull>> getDoctorAllVisits(String doctorId) {
        return new SuccessDataResult<List<VisitInfoFull>>(this.visitInfoFullDao.getByDoctorId(doctorId), "Doktorun Tüm Visitleri Listelendi");
    }

    @Override
    public DataResult<List<VisitInfoFull>> getAllActiveVisits() {
        return new SuccessDataResult<List<VisitInfoFull>>(this.visitInfoFullDao.findAllByVisitStatusIsTrue(), "Tüm Aktif Visitler Görüntülendi");
    }

    @Override
    public DataResult<List<VisitInfoFull>> getAllVisits() {
        return new SuccessDataResult<List<VisitInfoFull>>(this.visitInfoFullDao.findAll(), "Tüm Visitler Listelendi");
    }

    @Override
    public DataResult<Visit> getVisitById(Integer visitId) {
        return new SuccessDataResult<Visit>(this.visitDao.getById(visitId), "Seçilen Visit Görüntülendi");
    }

}
