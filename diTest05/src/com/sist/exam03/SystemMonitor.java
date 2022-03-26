package com.sist.exam03;

public class SystemMonitor {
	private long periodTime;
	private SmsSender sender;
	public SystemMonitor(long periodTime, SmsSender sender) {
		super();
		this.periodTime = periodTime;
		this.sender = sender;
	}
	
	public void monitor() {
		System.out.print(periodTime+"�� ��������");
		sender.send();
	}
}
