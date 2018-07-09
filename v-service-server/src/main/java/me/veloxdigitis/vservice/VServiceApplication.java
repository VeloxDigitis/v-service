package me.veloxdigitis.vservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@SpringBootApplication
@RestController
public class VServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VServiceApplication.class, args);
    }

    @RequestMapping("/ping")
    public ResponseEntity<?> ping() {
        return ResponseEntity.ok(Collections.singletonMap("ping", "pong"));
    }
}
