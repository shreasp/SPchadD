package com.udemy.springCoreDemo.common;

import com.udemy.springCoreDemo.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In Constructor" + getClass().getSimpleName());
    }
    // Define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("in DoMyStartupStuff() "+ getClass().getSimpleName() );
    }

    // Define out destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In DoMyCleanupStuff "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice Bowling for 15 mins";
    }
}
