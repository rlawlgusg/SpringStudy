package com.sist.exam05;

public class JobExecutor {
	public JobExecutor(String name, int seconds) {
		System.out.println("������ ȣ��1");
	}
	public JobExecutor(String name, long seconds) {
		System.out.println("������ ȣ��2");
	}
	public JobExecutor(String name, String seconds) {
		System.out.println("������ ȣ��3");
	}
	//�⺻������ String�� �켱������ ����!
	
	public void pro() {
		System.out.println("JobExecutor�� pro�Դϴ�");
	}
}
