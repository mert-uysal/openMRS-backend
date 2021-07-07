package openmrsproject.business.abstracts;

import openmrsproject.core.utilities.results.Result;

public interface LoginService {
    Result login(String username, String password);
}
