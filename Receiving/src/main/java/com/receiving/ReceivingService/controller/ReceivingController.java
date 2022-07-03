package com.receiving.ReceivingService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RestController
public class ReceivingController {
	
	@Autowired 
	private RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	private Logger log = LoggerFactory.getLogger(ReceivingController.class);
	
	@GetMapping("/receiving/{receivingId}")
	public String getReceivingInfo(@PathVariable String receivingId) {
		String response = "";
		log.info("From Receiving Service with Receiving Id :"+receivingId);
		if (receivingId.equalsIgnoreCase("1B") ) {
			response += "Product "+receivingId+" is received at Staging Lane ";
		}else {
			response += "Product "+receivingId+" is Received on Shipping Staging Lane ";
		}
	 	response += restTemplateBuilder.build().getForObject(eurekaClient.getNextServerFromEureka("NOTIFICATION SERVICE", false).getHomePageUrl()+"/notification/receiving", String.class);
	 	return response;
	}
}
