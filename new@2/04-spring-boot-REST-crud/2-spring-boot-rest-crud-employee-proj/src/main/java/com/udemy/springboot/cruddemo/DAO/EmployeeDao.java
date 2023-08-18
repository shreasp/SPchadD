package com.udemy.springboot.cruddemo.DAO;

import com.udemy.springboot.cruddemo.Entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
     Employee findById(int theId);

     Employee save (Employee theEmployee);

     void deleteById(int theId);
}
