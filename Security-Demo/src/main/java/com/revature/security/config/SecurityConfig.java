package com.revature.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

// tells Spring that this is a security configuration class
@EnableWebSecurity
// tells Spring that this class contains @Bean definitions
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // authorize all requests and make sure users are authenticated before they can access the HTTP requests;
        http.authorizeHttpRequests()
                .anyRequest()
                .authenticated();
        // form login, with text boxes:
//        http.formLogin();
        http.httpBasic();
        return http.build();
    }

}
