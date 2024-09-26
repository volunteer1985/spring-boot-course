package com.someserv.cruddemo.dao;

import com.someserv.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    EntityManager entityManager;

    @Autowired
    EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> employeeQuery = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employees =  employeeQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee theEmployee = entityManager.find(Employee.class, id);
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee employeeToDelete = entityManager.find(Employee.class, id);
        entityManager.remove(employeeToDelete);
    }
}
