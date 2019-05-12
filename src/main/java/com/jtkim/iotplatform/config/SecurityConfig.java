package com.jtkim.iotplatform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(HttpMethod.GET, "/api").permitAll()
            .anyRequest().fullyAuthenticated()
            .and().httpBasic()
            .and().csrf().disable();
        
        // Allowing same origin for H2 Console
        http.headers().frameOptions().sameOrigin();
    }
}