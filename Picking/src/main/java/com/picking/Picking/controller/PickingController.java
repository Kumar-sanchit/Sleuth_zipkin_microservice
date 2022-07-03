package com.picking.Picking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RestController
public class PickingController {
	@Autowired
	RestTemplateBuilder RestTemplateBuilder;
	
	@Autowired
	private EurekaClient eurekaClient;

	private Logger log = LoggerFactory.getLogger(PickingController.class);
	
	@GetMapping("/getPickingInfo/{pickingLocation}") 
	public String getPickingLocation(@PathVariable String pickingLocation) {
		String response = "";
		log.info("From Picking Service with picking Location :"+pickingLocation);
		if (pickingLocation.equalsIgnoreCase("1SR02")) {
			response = "Shipping Receiving Location ";
		} 
		else {
			response = "Shipping Staging Location ";
		}
		log.info("From Picking Service calling Notification Service!");
		response += RestTemplateBuilder.build().getForObject(
				eurekaClient.getNextServerFromEureka("NOTIFICATION SERVICE", false).getHomePageUrl()+"/notification/Picking", String.class);
		log.info("From Picking Service called Notification Service!");
		return response;
	}
}