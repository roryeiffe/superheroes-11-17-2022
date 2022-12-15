package com.revature.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// tells Spring that this is a security configuration class
@EnableWebSecurity
// tells Spring that this class contains @Bean definitions
@Configuration
public class SecurityConfig {

    @Autowired
    EncoderConfig encoderConfig;

    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // configure our auth manager to use our user details service as well as the bcrypt passwrod encoder
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(encoderConfig.passwordEncoder());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                // we want to anyone to be able to access the authenticate endpoint (otherwise, no one would be able to log in)
                .authorizeHttpRequests().requestMatchers("/authenticate").permitAll()
                // any other request, should be authenticated:
                .anyRequest().authenticated().and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // configure our filter to use the request filter that we set up:
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        // authorize all requests and make sure users are authenticated before they can access the HTTP requests;
//        http.authorizeHttpRequests()
//                .anyRequest()
//                .authenticated();
//        // form login, with text boxes:
////        http.formLogin();
//        http.httpBasic();
//        return http.build();
//    }






}
