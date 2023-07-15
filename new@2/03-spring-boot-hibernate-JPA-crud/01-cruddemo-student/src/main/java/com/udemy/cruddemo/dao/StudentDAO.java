package com.udemy.cruddemo.dao;

import com.udemy.cruddemo.entity.Student;

public interface StudentDAO {

    void save( Student student);
    Student findById(Integer id);
}
