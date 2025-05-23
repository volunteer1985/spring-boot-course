package com.love2code.springboot.thymeleafdemo.controller;

import com.love2code.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> favoriteLanguages;

    @Value("${systems}")
    private List<String> favoriteSystems;

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model theModel){

        //Create Student object
        Student theStudent = new Student();

        //add Student object to Model attributes
        theModel.addAttribute("student", theStudent);

        //add countries list to the model
        theModel.addAttribute("countries", countries);

        theModel.addAttribute("languages", favoriteLanguages);

        theModel.addAttribute("systems", favoriteSystems);


        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        //logging student
        System.out.println( "Student " + theStudent.getFirstName() + " " + theStudent.getLastName());
        System.out.println("Country: " + theStudent.getCountry());
        System.out.println("Favorite Programming Language: " + theStudent.getFavoriteLanguage());
        System.out.println("Favorite Operating Systems: " + theStudent.getFavoriteSystems());

        return "student-confirmation";
    }

}
