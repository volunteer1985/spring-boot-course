package com.someserv.cruddemo.rest;

import com.someserv.cruddemo.entity.Employee;
import com.someserv.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee not found by id " + employeeId);
        }
       return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    
    @DeleteMapping("/employees/{employeeId}")
    public String deleteById(@PathVariable int employeeId) {
    	Employee dbEmployee = employeeService.findById(employeeId);
    	if (dbEmployee == null) {
    		throw new RuntimeException("No employee found with id=" + employeeId);
    	}
    	employeeService.deleteById(employeeId);
		return "Emloyee successfully deleted by id=" + employeeId;
		
    }
    



}
