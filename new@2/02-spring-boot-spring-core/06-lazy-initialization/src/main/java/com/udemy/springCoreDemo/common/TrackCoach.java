package com.udemy.springCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// added primary now
@Primary
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Keep running 5kms";
    }
}
