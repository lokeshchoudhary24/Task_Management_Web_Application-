package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.service.impl.CustomPasswordEncoder;
import com.app.service.impl.PasswordEncoder;

@Configuration
public class SecurityConfig {

    // Define a bean for custom PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return (PasswordEncoder) new CustomPasswordEncoder();
    }
}
