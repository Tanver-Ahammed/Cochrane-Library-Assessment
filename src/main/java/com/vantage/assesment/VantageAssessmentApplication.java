package com.vantage.assesment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author: Md. Tanver Ahammed
 */

@SpringBootApplication
public class VantageAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(VantageAssessmentApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
