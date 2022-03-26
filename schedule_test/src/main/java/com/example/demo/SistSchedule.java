package com.example.demo;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SistSchedule {
	
	@Scheduled(fixedRate = 10000)
	public void pro() {
		System.out.println("콜! 콜!");
	}
	
	//매일 오전 9시 29분에 동작하도록
	@Scheduled(cron = "0 31 9 * * ?")
	public void pro2() {
		System.out.println("pro2");
	}
	
	//매월 7일 9시 35분에 hello를 출력
	@Scheduled(cron = "0 35 9 7 * ?")
	public void pro3() {
		System.out.println("hello");
	}
}
