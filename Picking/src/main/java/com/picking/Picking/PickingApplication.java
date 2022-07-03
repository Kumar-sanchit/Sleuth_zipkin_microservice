package com.picking.Picking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PickingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PickingApplication.class, args);
	}

}
