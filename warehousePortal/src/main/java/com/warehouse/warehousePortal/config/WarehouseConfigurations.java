package com.warehouse.warehousePortal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WarehouseConfigurations {

	
	@Autowired
	private RestTemplateBuilder restTemplatebuidler;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return restTemplatebuidler.build();
	}	
}
