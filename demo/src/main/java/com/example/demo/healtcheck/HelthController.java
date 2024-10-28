package com.example.demo.healtcheck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelthController {

    @GetMapping("/health")
    public String checkAPI(){
        return "<h1>The API is working ok!</h1>";
    }

}
