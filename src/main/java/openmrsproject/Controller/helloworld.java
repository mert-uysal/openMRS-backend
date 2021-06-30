package openmrsproject.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class helloworld {
    public helloworld() {
    }

    @GetMapping("/hello")
    public String Hello(){
        return "hello world";
    }
}
