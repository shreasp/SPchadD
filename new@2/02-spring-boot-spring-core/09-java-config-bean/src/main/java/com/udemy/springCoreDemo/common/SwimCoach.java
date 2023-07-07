package com.udemy.springCoreDemo.common;

import org.springframework.context.annotation.Bean;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In Constructor " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Keep Swimming till 1000m ! ";
    }
}
