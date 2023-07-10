package com.udemy.springCoreDemo.common;

import com.udemy.springCoreDemo.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In Constructor" + getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "Practice Bowling now for 15 mins ";
    }
}
