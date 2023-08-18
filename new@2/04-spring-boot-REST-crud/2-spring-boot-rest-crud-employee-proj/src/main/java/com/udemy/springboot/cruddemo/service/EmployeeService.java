package com.udemy.springboot.cruddemo.service;

import com.udemy.springboot.cruddemo.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    List <Employee>  findAll();
}
