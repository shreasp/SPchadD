package com.udemy.dem.rest;

import com.udemy.dem.Entity.Student;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



        //CHECK THE student id against thr list size
        if (studentId>= theStudents.size() || studentId<0){
            throw new StudentNotFoundException("Student id not found -" + studentId);
        }

        return theStudents.get(studentId);
    }
    // add an exception handler using @ExceptionHandler annotation

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        // create student error response

        StudentErrorResponse error =new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        // Return response entity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    // add another exception handler ... to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse error =new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        // Return response entity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);




    }



}
