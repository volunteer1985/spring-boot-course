package com.volunteer.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling traps for 15 minutes!";
    }
}
