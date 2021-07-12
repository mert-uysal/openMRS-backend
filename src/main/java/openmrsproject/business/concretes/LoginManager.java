package openmrsproject.business.concretes;

import openmrsproject.business.abstracts.LoginService;
import openmrsproject.core.utilities.results.DataResult;
import openmrsproject.core.utilities.results.ErrorDataResult;
import openmrsproject.core.utilities.results.SuccessDataResult;
import openmrsproject.dataAccess.abstracts.LoginDao;
import openmrsproject.entities.abstracts.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginManager implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public DataResult<User> login(String username, String password) {
        if(!this.loginDao.existsUserByUsername(username)){
            System.out.println("Hatalı Kulanıcı Adı !!");
            return new ErrorDataResult<User>("Hatalı Kulanıcı Adı !!");
        }
        else {
            User existUser = this.loginDao.findUserByUsername(username);
            if(!existUser.getUserPassword().equals(password)){
                return new ErrorDataResult<User>("Hatalı veya Eksik Şifre !!");
            }
            else {
                return new SuccessDataResult<User>(existUser, "Kullanıcı Girişi Başarılı.");
            }
        }
    }
}
