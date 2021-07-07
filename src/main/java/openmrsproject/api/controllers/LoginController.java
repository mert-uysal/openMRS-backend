package openmrsproject.api.controllers;

import openmrsproject.business.abstracts.LoginService;
import openmrsproject.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/")
    public Result login(String username, String password) {
        return this.loginService.login(username, password);
    }
}
