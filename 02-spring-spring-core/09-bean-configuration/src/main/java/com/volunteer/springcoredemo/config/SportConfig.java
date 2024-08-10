package com.volunteer.springcoredemo.config;

import com.volunteer.springcoredemo.common.Coach;
import com.volunteer.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
