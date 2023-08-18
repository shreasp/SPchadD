package com.udemy.springboot.cruddemo.DAO;

import com.udemy.springboot.cruddemo.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    // add field for entity manager
    private EntityManager entityManager;

    // setup constructor injection

    @Autowired
    public EmployeeDaoImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;

    }
    @Override
    public List<Employee> findAll() {

        //create a query

        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee" ,Employee.class);

        // execute the query
        List <Employee> employees =theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // get employee
        Employee theEmployee = entityManager.find(Employee.class,theId);

        // return employee

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee dbEmployee=entityManager.merge(theEmployee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // find by id

        Employee theEmployee = entityManager.find(Employee.class,theId);

        // remove employee

        entityManager.remove(theEmployee);



    }
}
