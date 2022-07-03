package com.notification.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
	
	private Logger log = LoggerFactory.getLogger(NotificationController.class);

	@GetMapping("/notification/{serviceName}")
	public String getNotification(@PathVariable String serviceName) {
		log.info("From Notification Service!");
		if (serviceName.equalsIgnoreCase("Receiving")) {
			return "Notified from Receiving Service";
		}
		if (serviceName.equalsIgnoreCase("Shipping")) {
			return "Notified from Shipping Service";
		}
		if (serviceName.equalsIgnoreCase("Picking")) {
			return "Notified from Picking Service";
		}
		return "Notification is called!";
	}
}
