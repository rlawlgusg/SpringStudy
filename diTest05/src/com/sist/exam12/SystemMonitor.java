package com.sist.exam12;

public class SystemMonitor {
	private long periodTime;
	private SmsSender sender;
	
	
	
	public void setPeriodTime(long periodTime) {
		this.periodTime = periodTime;
	}



	public void setSender(SmsSender sender) {
		this.sender = sender;
	}



	public void monitor() {
		System.out.print(periodTime+"�� �������� ");
		sender.send();
	}
}
