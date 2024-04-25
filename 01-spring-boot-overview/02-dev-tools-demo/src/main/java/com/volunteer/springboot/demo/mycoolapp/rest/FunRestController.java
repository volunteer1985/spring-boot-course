package com.volunteer.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getWorkout(){
        return "Go, go, go!";
    }

    @GetMapping("/fortune")
    public String getFortune(){
        return "It is your lucky day!";
    }
}
