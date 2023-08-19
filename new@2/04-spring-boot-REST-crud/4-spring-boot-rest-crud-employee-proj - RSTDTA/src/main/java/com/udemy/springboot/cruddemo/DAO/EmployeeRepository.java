package com.udemy.springboot.cruddemo.DAO;

import com.udemy.springboot.cruddemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // no need to write any other code
}
