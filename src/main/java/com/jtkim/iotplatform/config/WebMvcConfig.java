package com.jtkim.iotplatform.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jtkim.iotplatform.interceptor.MeasurementInterceptor;

@Configuration
@ComponentScan({"com.jtkim.iotplatform"})
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MeasurementInterceptor());
    }
}