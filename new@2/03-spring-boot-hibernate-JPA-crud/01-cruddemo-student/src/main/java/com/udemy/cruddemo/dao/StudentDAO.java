package com.udemy.cruddemo.dao;

import com.udemy.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save( Student student);
    Student findById(Integer id);

    List <Student> findAll();

    List<Student> findByLastName(String theLastName);
}
