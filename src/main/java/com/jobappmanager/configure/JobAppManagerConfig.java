package com.jobappmanager.configure;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobAppManagerConfig {
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
