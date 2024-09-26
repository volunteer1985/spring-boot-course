package com.someserv.cruddemo.rest;

import com.someserv.cruddemo.dao.EmployeeDAO;
import com.someserv.cruddemo.entity.Employee;
import com.someserv.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRestController {
    EmployeeService employeeService;

    EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
}
