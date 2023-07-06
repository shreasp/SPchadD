package com.udemy.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("In Constructor" + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice TENNIS back and forth for 25 mins";
    }
}
