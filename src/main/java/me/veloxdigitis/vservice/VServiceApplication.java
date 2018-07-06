package me.veloxdigitis.vservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VServiceApplication {

    @RequestMapping("/")
    public String index() {
        return "Hello world";
    }
}
