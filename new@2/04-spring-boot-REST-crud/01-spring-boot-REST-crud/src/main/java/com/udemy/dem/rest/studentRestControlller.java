package com.udemy.dem.rest;

import com.udemy.dem.Entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class studentRestControlller {

    // define endpoint for /students to return list opf students
    @GetMapping("/students")
    public List<Student> getStudents()  {

        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("poorna","patel"));
        theStudents.add(new Student("mario","rossi"));
        theStudents.add(new Student("mary","smith"));

        return theStudents;
    }




}
