package com.ud.springboot.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class FunRestController {

    // inject properties for coach name and team name

    @Value("${team.name}")
    public String teamName;

    @Value("${coach.name}")
    public String coachName;

    //expose endpoint for teaminfo
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Team: " + teamName + "  and coach name is :"+ coachName;
    }

    //expose endpoint for coachinfo
    @GetMapping("/coachinfo")
    public String getCoachInfo(){
        return  "Coach: "+ coachName;
    }




   @GetMapping("/")
    public String hello(){
        return "Hello World!";
    }

    // expose new endpoint for workout
    @GetMapping ("/workout")
    public String getDailyWorkout(){
       return "Run a hard 5k";
    }


    // expose new endpoint for fortune
    @GetMapping("/fortune")
    public String getDailyFortune(){
       return "Lucky Day";
    }
}
