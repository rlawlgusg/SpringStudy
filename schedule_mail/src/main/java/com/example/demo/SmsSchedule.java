package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.service.SendPhoneService;

import lombok.Setter;

@Component
@EnableScheduling
@Setter
public class SmsSchedule {
	
	@Autowired
	private SendPhoneService phoneService;
	
	//@Scheduled(cron = "0 0 9,14 * * ?")
	//@Scheduled(cron = "0 34 9,14,15 * * ?")
	//public void send() {
	//	phoneService.sendMsg();
	//}
}
