package openmrsproject.api.controllers;

import openmrsproject.business.abstracts.LoginService;
import openmrsproject.core.utilities.results.Result;
import openmrsproject.entities.abstracts.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/")
    public Result login(@RequestBody User user) {
        return this.loginService.login(user.getUsername(), user.getUserPassword());
    }
}
