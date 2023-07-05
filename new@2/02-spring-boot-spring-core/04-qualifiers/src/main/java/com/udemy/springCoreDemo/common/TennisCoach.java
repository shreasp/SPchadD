package com.udemy.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice TENNIS back and forth for 25 mins";
    }
}
