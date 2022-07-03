package com.shipping.Shipping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RestController
public class ShippingController {

	@Autowired
	private RestTemplateBuilder builder;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	private Logger log = LoggerFactory.getLogger(ShippingController.class);
	
	@GetMapping("/ship/{item}")
	public String shipItem(@PathVariable String item) {
		String response = "";
		log.info("From Shipping Service /ship/{item} end point with Item :"+item);
		response += "item "+item+" has been Shipped ";
		log.info("Calling Notification service from Shipping service!");
		response += builder.build().getForObject(eurekaClient.getNextServerFromEureka("NOTIFICATION SERVICE", false).getHomePageUrl()+"/notification/Shipping", String.class);
		log.info("Got response from Notification service :"+response);
		return response;
	}
}