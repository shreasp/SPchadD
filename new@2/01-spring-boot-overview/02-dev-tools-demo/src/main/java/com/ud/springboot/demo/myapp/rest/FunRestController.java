package com.ud.springboot.demo.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class FunRestController {
   @GetMapping("/")
    public String hello(){
        return "Hello World!";
    }

    // expose new endpoint for workout
    @GetMapping ("/workout")
    public String getDailyWorkout(){
       return "Run a hard 5k";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
       return "Lucky Day";
    }
}
