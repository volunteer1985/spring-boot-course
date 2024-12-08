package com.love2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelleWorldController {

    //create method to show HTML form
    @GetMapping("showForm")
    public String showForm(){
        return "helloworld-form";
    }
}
