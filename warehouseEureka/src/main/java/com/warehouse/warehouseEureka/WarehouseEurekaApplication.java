package com.warehouse.warehouseEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class WarehouseEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarehouseEurekaApplication.class, args);
	}

}
