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
        //TypedQuery<Student> theQuery= entityManager.createQuery("FROM Student ", Student.class);
        //TypedQuery<Student> theQuery= entityManager.createQuery("FROM Student order by lastName desc", Student.class);
        TypedQuery<Student> theQuery= entityManager.createQuery("FROM Student ", Student.class);




        //TypedQuery<Student> theQuery= entityManager.createQuery("FROM Student order by lastName asc  ", Student.class);
        // Return Query
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName =:theData",
                Student.class);

        // set query parameters
        theQuery.setParameter("theData",theLastName);


        // return query results
        return theQuery.getResultList();




    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        //retrieving the student
        Student theStudent = entityManager.find(Student.class, id);


        // delete the student
        entityManager.remove(theStudent);


    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student ").executeUpdate();

        return numRowsDeleted;
    }


}