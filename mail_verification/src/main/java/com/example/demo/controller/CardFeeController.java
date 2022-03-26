package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.CardDAO;
import com.example.demo.vo.MemberCardFee;

import lombok.Setter;

@Controller
@Setter
public class CardFeeController {
	@Autowired
	private CardDAO dao;
	@Autowired
	private JavaMailSender javaMailSender;
	
	@RequestMapping("/sendCardFee")
	@ResponseBody
	public String send() {
		List<MemberCardFee> list = dao.selectCardFee();
			for(MemberCardFee m: list) {				
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setFrom("wlguswlgusg@google.com");//구글 계정의 메일주소
				mailMessage.setTo(m.getEmail());//받는 사람 이메일주소
				mailMessage.setSubject(m.getName()+"님 이번달 명세서 입니다. [담당자:김지현]");
				mailMessage.setText(m.getName()+"님 카드사용금액은 "+m.getAmount()+"원 입니다");

			try {
				javaMailSender.send(mailMessage);
				System.out.println(m.getName()+ "님에게 메세지를 전송하였습니다.");
			}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
			}
		}	
		return "카드명세서를 발송하였습니다.";
	}	
}