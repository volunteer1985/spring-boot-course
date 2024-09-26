package com.someserv.cruddemo.service;

import com.someserv.cruddemo.dao.EmployeeDAO;
import com.someserv.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;

    @Autowired
    EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById() {
        return null;
    }
}
