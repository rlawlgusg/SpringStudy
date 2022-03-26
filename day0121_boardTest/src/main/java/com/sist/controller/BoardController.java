package com.sist.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;

	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listBoard.do")
	private ModelAndView listAll() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll());
		return mav;
	}
	
	@RequestMapping(value = "/insertBoard.do" ,method = RequestMethod.GET)
	private void insertForm(BoardVO b) {
		
	}
	
	@RequestMapping(value = "/insertBoard.do" ,method = RequestMethod.POST)
	private ModelAndView insertSubmit(HttpServletRequest request ,BoardVO b) {
		String path = request.getRealPath("images");
		System.out.println("path:"+path);
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		
		MultipartFile uploadFile = b.getUploadFile();
		String fname = uploadFile.getOriginalFilename();

		byte []data=null;
		try {
			data = uploadFile.getBytes();
			if(fname != null && !fname.equals("")) {	
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				b.setFname(fname);
			}else {
				b.setFname("");
			}
		} catch (Exception e) {}
		
		int re =  dao.insert(b);
		
	
		if(re == 1) {
			try {
				if(fname != null && !fname.equals("")) {	
					FileOutputStream fos = new FileOutputStream(path+"/"+fname);
					fos.write(data);
				}
				}catch(Exception e) {}
		}else {
			
			mav.setViewName("error");
			mav.addObject("msg", "�Խ��ǵ�Ͽ� �����Ͽ����ϴ�");
		}
		return mav;
	}
	
}
