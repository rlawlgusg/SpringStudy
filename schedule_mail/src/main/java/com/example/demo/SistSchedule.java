package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.service.SendEmailService;

import lombok.Setter;

@Component
@EnableScheduling
@Setter
public class SistSchedule {
	@Autowired
	private SendEmailService emailService;
	
	
	//@Scheduled(cron = "0 21 12 7 * ?")
	//public void pro() {
	//	emailService.sendEmail();
	//}
	
	
}
