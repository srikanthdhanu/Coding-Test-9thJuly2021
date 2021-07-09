package com.promotionengine.demoapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class DemoapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoapplicationApplication.class, args);
	}

}
