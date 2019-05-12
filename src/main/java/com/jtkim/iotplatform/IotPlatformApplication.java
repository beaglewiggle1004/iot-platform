package com.jtkim.iotplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class IotPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotPlatformApplication.class, args);
	}

}
