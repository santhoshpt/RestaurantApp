package com.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RestaurantAppProperties.class)
public class TestConfiguration implements ApplicationRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(TestConfiguration.class);
	
	@Autowired
	private RestaurantAppProperties resProp;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info(">>> Testing Application Runner");
		System.out.println(">>> Testing Application Runner" );
		System.out.println(">>> Loading properties " + resProp.toString());
	}
}
