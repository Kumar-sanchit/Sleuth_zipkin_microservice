package com.warehouse.warehousePortal.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;
import com.warehouse.warehousePortal.config.WarehouseConfigurations;

@RestController
public class WareHouseController {
	
	Logger log = org.slf4j.LoggerFactory.getLogger(WareHouseController.class);
	
	@Autowired
	private WarehouseConfigurations warehouseConfig;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@GetMapping("/info")
	public String getString() {
		return "hello from eureka discovery client portal";
	}
	
	@GetMapping("/receivingInfo")
	public String getReceivingInfo() {
		String response = "";
		log.info("From warehouse portal calling Receiving End point");
		String url = eurekaClient.getNextServerFromEureka("RECEIVING SERVICE", false).getHomePageUrl();
		RestTemplate template = warehouseConfig.getRestTemplate();
		response = template.getForObject(url+"/receiving/1B", String.class);
		log.info("From warehouse portal received Response from Receiving End Point!");
		return response;
	}
	
	
	@GetMapping("/ShippingInfo")
	public String getShippingInfo() {
		String response = "";
		log.info("From Warehouse Portal calling Shipping End point!");
		String url = eurekaClient.getNextServerFromEureka("SHIPPING SERVICE", false).getHomePageUrl();
		RestTemplate template = warehouseConfig.getRestTemplate();
		response = template.getForObject(url+"/ship/Toy", String.class);
		log.info("From Warehouse portal received response from Shipping Service!");
		return response;
	}
	
	@GetMapping("/PickingInfo") 
	public String getPickingInfo() {
		String response = "";
		log.info("From Warehouse Portal calling Picking End point!");
		String url = eurekaClient.getNextServerFromEureka("PICKING SERVICE", false).getHomePageUrl();
		RestTemplate restTemplate = warehouseConfig.getRestTemplate();
		response = restTemplate.getForObject(url+"/getPickingInfo/1SR02", String.class);
		log.info("From Warehouse portal received response from Picking Service!");
		return response;
	}
}