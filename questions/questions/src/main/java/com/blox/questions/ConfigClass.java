package com.blox.questions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {

	 @Bean
	 RateLimiterService rateLimiterService() 
	 {	 
		 return new RateLimiterService();
	 }
	
}
