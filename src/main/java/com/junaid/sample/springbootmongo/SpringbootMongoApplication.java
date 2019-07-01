package com.junaid.sample.springbootmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.junaid.sample"})
public class SpringbootMongoApplication {	
	
	public static void main(String[] args) {		
		SpringApplication.run(SpringbootMongoApplication.class, args);
	}

}
