package com.poc.userNotificationService.UserNotificationService.notification;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserNotificationListener {
	
	@KafkaListener(topics="users", groupId = "user-notification-group")
	public void handleUserEvents(String event) {
		
		String[] parts = event.split(":");
		//System.out.println("parts --> "+parts);
		String eventType = parts[0];
		
		switch(eventType) {
		
		case "userRegistered":
			System.out.println("Received kafka event :" + event + " Sending welcome mail");
			break;
			
		case "userDeleted":
			System.out.println("Received kafka event :" + event + " Deleting user data");
			break;
		
		
		}
		
	}

}
