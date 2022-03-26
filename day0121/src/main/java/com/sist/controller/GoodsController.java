package com.sist.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/listGoods.do")
	public ModelAndView findAll(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.findAll());
		return mav;
	}
	
	
	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.GET)
	public void insertForm() {		
	}
	
	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(HttpServletRequest request, GoodsVO g) {
		//업로드할 폴더의 실경로를 알아오기 위하여 request객체를 선언
		String path = request.getRealPath("images");
		System.out.println("path:"+path);
		//request객체를 통하여 업로드할 폴더의 실제경로를 읽어옴
		MultipartFile uploadFile = g.getUploadFile();
		//vo에 업로드한 파일의 정보를 받아옴
		String fname = uploadFile.getOriginalFilename();
		//업로드한 파일이름을 알아봄
		byte[] data; 
		try {
			data = uploadFile.getBytes();
			//업로드한 파일의 내용을 받아옴
			FileOutputStream fos = new FileOutputStream(path+"/"+fname);
			//서버에 파일을 출력하기 위한 스트림을 생성함
			fos.write(data);
			//서버에 파일을 출력
			fos.close();
		}catch(Exception e) {}
		
		g.setFname(fname);
		int re = dao.insert(g);
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "상품 등록에 실패하였습니다.");
		}
		return mav;
	}
	@RequestMapping("/detailGoods.do")
	public ModelAndView detail(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("g", dao.findByNO(no));
		return mav;
	}
	
	@RequestMapping(value = "/updateGoods.do", method = RequestMethod.GET)
	public ModelAndView updateForm(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("g", dao.findByNO(no));
		return mav;
	}
	

	@RequestMapping(value = "/updateGoods.do", method = RequestMethod.POST)
	public ModelAndView updateSubmit(HttpServletRequest request, GoodsVO g) {
		String path = request.getRealPath("images");
		
		//원래 사진이름을 미리 변수에 담아둠
		String oldFname = g.getFname();
		
		//업로드한 파일의 정보를 받아옴
		MultipartFile uploadFile = g.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		byte []data;
		try {
			data = uploadFile.getBytes();
			
			//만약에 사진도 수정했다면 
			//업로드한 파일이 있다면 파일을 복사함
			if(fname != null && !fname.equals("")) {
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				g.setFname(fname);
			}
		} catch (Exception e) {}
		
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		//list로 가는 redirect빼먹지 말자 >> javax.el.PropertyNotFoundException 오류원인 
		int re = dao.update(g);
		mav.addObject("g", dao.update(g));
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "상품수정에 실패하였습니다");
		}else {//수정에 성공했고
			if(fname != null && !fname.equals("")) {//사진도 수정했다면
				File file = new File(path+"/"+oldFname);
				file.delete();//원래 사진을 삭제함
			}
		}
		return mav;
	}
	
	@RequestMapping("/deleteGoods.do")
	public ModelAndView deleteGoods(HttpServletRequest request, int no) {
		String path = request.getRealPath("images");
		//지우고자 하는 상품의 사진파일 이름을 미리 저장
		String oldFname = dao.findByNO(no).getFname();
		
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		int re = dao.delete(no);
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "상품 삭제에 실패하였습니다");
		}else {
			File file = new File(path+"/"+oldFname);
			file.delete();
		}
		return mav;
	}
	
}
