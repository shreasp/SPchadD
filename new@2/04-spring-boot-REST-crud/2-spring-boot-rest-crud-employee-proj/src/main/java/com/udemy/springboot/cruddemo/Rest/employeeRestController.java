package com.udemy.springboot.cruddemo.Rest;


import com.udemy.springboot.cruddemo.DAO.EmployeeDao;
import com.udemy.springboot.cruddemo.Entity.Employee;
import com.udemy.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // add mapping for GET employee w id
    @GetMapping("/employees/{employeeId}")
    public Employee getById(@PathVariable int employeeId){
        Employee theEmployee= employeeService.findById(employeeId);
        if (theEmployee== null){
            throw new RuntimeException("Employee id not found -" + employeeId);
        }
        return theEmployee;
    }

    // add mapping for POST employees  - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // also just in case if they pass an id in json set id =0
        // that is to save new item instead of an update

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
}
