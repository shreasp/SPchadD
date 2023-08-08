package com.udemy.dem.rest;

import com.udemy.dem.Entity.Student;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class studentRestControlller {

    private List < Student> theStudents;

    // define @PostConstruct to loan students data...only once!!
    @PostConstruct
    public void loadData(){

        theStudents= new ArrayList<>();

        theStudents.add(new Student("poorna","patel"));
        theStudents.add(new Student("mario","rossi"));
        theStudents.add(new Student("mary","smith"));

    }

    // define endpoint for /students to return list opf students
    @GetMapping("/students")
    public List<Student> getStudents(){



        return theStudents;
    }

    // define endpoint or "/students/{studentId}" to return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // just index into the list

        return theStudents.get(studentId);
    }


}
