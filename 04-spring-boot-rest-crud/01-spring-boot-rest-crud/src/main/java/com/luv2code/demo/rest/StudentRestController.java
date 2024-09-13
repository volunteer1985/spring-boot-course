package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("Zaiets", "Zaitsiv"));
        theStudents.add(new Student("Kolobok", "Kolobkiv"));
        theStudents.add(new Student("Koty", "Horoshko"));
        return theStudents;
    }
}