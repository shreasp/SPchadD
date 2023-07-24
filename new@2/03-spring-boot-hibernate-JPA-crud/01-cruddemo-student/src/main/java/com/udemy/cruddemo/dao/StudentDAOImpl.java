package com.udemy.cruddemo.dao;

import com.udemy.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //DEFINE FIELD FOR entity manager
    private EntityManager entityManager;


    //inject entity manager using cons injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //implement save method
        @Override
        @Transactional
         public void save(Student theStudent) {
            entityManager.persist(theStudent);
    }

    // implementing find by id method
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        // Create Query
        TypedQuery<Student> theQuery= entityManager.createQuery("FROM Student ", Student.class);
        // Return Query
        return theQuery.getResultList();
    }


}