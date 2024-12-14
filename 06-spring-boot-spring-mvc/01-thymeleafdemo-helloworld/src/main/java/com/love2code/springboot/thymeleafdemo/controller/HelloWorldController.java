package com.love2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //create method to show HTML form
    @GetMapping("showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //create method to process HTML form
    //@RequestMapping by default handles all types of request
    //@RequestMapping("processForm")
    //public String processForm(){
    //    return "helloworld";
    //}

    //Other type of mapping - handles only specific type of request
    @GetMapping("processForm")
    public String processForm(){
        return "helloworld";
    }

    //process HTML form using model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDudes(HttpServletRequest request, Model model){
        //read the request param
        String theName = request.getParameter("studentName");

        //convert the data to all caps
        theName = theName.toUpperCase();

        //create the message
        String message = "YO! " + theName;

        //add message to the model
        model.addAttribute("message", message);
        return "helloworld";
    }

    //process HTML form using model and @RequestParam annotation
    @PostMapping("/processFormVersionThree")
    public String processReqVerThree(@RequestParam("studentName") String theName, Model model){

        //convert the data to all caps
        theName = theName.toUpperCase();

        String message = theName + "!";

                //add message to the model
        model.addAttribute("message", message);
        return "helloworld";
    }
}
