package com.udemy.springboot.cruddemo.Rest;


import com.udemy.springboot.cruddemo.DAO.EmployeeDao;
import com.udemy.springboot.cruddemo.Entity.Employee;
import com.udemy.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class employeeRestController {

    private EmployeeService employeeService;


    @Autowired
    public employeeRestController(EmployeeService theEmployeeService){
        employeeService= theEmployeeService;
    }
    // expose /employees and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();

    }

}
