package com.someserv.cruddemo.service;

import com.someserv.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById();
}