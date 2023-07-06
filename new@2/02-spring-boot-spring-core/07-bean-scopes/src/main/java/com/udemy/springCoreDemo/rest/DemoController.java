package com.udemy.springCoreDemo.rest;

import com.udemy.springCoreDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for dependency
     private Coach myCoach;
     private Coach anotherCoach;

    //setter injection


    @Autowired
    public void DemoController(
            @Qualifier("baseballCoach") Coach theCoach,
            @Qualifier("baseballCoach")Coach theAnotherCoach){
        System.out.println("In Constructor" + getClass().getSimpleName());
        myCoach=theCoach;
        anotherCoach=theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }


    @GetMapping("/check")
    public String check(){
        return "Comparing beans : myCoach == anotherCoach       ," + (myCoach==anotherCoach);
    }

}
