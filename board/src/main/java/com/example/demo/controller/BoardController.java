package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.BoardVO;
import com.example.demo.vo.MemberVO;

import lombok.Setter;

@Controller
@Setter
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("/listBoard")
	public void list(
			HttpSession session,//정렬칼럼,검색칼럼,검색어를 상태유지하기 위하여 session변수를 매개변수로 선언
			Model model,//view페이지에서 필요한 데이터를 유지하기 위하여 Model을 선언함
			String orderColumn,//검색칼럼을 받아오기 위한 변수
			String keyword,//검색어를 받아오기 위한 변수
			String searchColumn,//정렬칼럼을 받아오기 위한 변수
			String writer,
			@RequestParam(value = "pageNum",defaultValue = "1") int pageNum){
	
		if(writer == null && session.getAttribute("writer") != null) {
			writer = (String)session.getAttribute("writer");
		}		
		
		
		//만약에 새로운 정렬이 없고 세션에 정렬칼럼명이 저장되어 있다면 
		//세션에 저장된 정렬칼럼명을 읽어옴
		if(orderColumn == null && session.getAttribute("orderColumn")!=null) {
			orderColumn = (String)session.getAttribute("orderColumn");
		}
		//만약, 새로운 검색어가 없고 
		//세션에 검색어가 저장되어 있다면
		//세션에 저장된 검색칼럼명과 검색어를 읽어옴
		if(keyword == null) {
			if(session.getAttribute("keyword")!= null) {
				searchColumn = (String)session.getAttribute("searchColumn");
				keyword = (String)session.getAttribute("keyword");
			}
		}
		System.out.println("정렬칼럼:"+orderColumn);
		System.out.println("pageNum:"+pageNum);

		System.out.println("검색칼럼:"+searchColumn);
		System.out.println("keyword:|"+keyword+"|");
		System.out.println("작성자:|"+writer+"|");
//		if(orderColumn == null) {
//			orderColumn = "no";
//		}
		
		//현재페이지에 보여줄 시작 레코드와 마지막 레코드의 위치를 계산함
		int start = (pageNum-1)*dao.pageSize+1;
		int end = start+dao.pageSize-1;
		
		//Dao가 게시물 목록을 검색할 때 필요한
		//정보(정렬칼럼명,검색칼럼명,검색어,현재페이지에 보여줄 시작레코드 위치, 마지막 레코드)
		//들을 map에 저장함
		HashMap map = new HashMap();
		map.put("orderColumn", orderColumn);
		map.put("searchColumn", searchColumn);
		map.put("keyword", keyword);
		
		map.put("start", start);
		map.put("end", end);
		map.put("writer", writer);
		//dao를 통해 검색한 결과를 model에 저장함
		//이때 findAll메소드에서 전체레코드수를 구하고
		//그 값을 갖고 전체페이지수도 계산함
		model.addAttribute("list", dao.findAll(map));
		//dao에 계산된 전체페이지수를 model에 상태유지함
		model.addAttribute("totalPage", dao.totalPage);
		//만약에 정렬하였다면 정렬칼럼이름을 세션에 저장하여 상태유지 함
		
		if(orderColumn!=null) {
			session.setAttribute("orderColumn", orderColumn);
		}
		//만약에 검색하였다면 검색한 칼럼과 검색어를 세션에 저장하여 상태유지함
		if(keyword != null) {
			session.setAttribute("searchColumn", searchColumn);
			session.setAttribute("keyword", keyword);
		}
		if(writer != null) {
			session.setAttribute("writer", writer);
		}
	}
	
	@RequestMapping(value = "/insertBoard",method = RequestMethod.GET)
	public void insertForm(Model model) {
		model.addAttribute("no", dao.getNextNo());
	}
	
	@RequestMapping(value = "/insertBoard",method = RequestMethod.POST)
	public ModelAndView insertSubmit(HttpServletRequest request, BoardVO b) {
		String ip = request.getRemoteAddr();
		System.out.println(ip);
		b.setIp(ip);
		
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		String path = request.getRealPath("images");
		System.out.println("path:"+path);
		b.setFname("");
		
		
		MultipartFile uploadFile = b.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			b.setFname(fname);
		}
		
		int re = dao.insert(b);
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "게시판등록에 실패했습니다");
		}else {
			
			try {
				byte []data = uploadFile.getBytes();
				if(fname != null && !fname.equals("")) {
					FileOutputStream fos = new FileOutputStream(path+"/"+fname);
					fos.write(data);
					fos.close();
				}
			
			} catch (Exception e) {}
		}
		return mav;
	}
	
	@RequestMapping("/detailBoard")
	public void findByNo(int no,Model model) {
		dao.updateHit(no);
		model.addAttribute("b",dao.findByNo(no) );
	}
	
	@RequestMapping(value = "/updateBoard", method = RequestMethod.GET)
	public void updateForm(Model model,int no) {
		model.addAttribute("b", dao.findByNo(no));
	}
	
	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public ModelAndView updateSubmit(BoardVO b,HttpServletRequest request) {
		String path = request.getRealPath("images");
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		String oldFname = b.getFname();
		MultipartFile uploadFile = b.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		
		if(fname != null & !fname.equals("")) {
			b.setFname(fname);
		}
	
		
		int re = dao.update(b);
		if(re == 1) {
			//게시물 수정에 성공했고, 또 첨부파일도 수정했다면, 
			//파일 복사를 해줌!
			if(fname!=null&&!fname.equals("")) {
				try {
					byte []date =  uploadFile.getBytes();
					FileOutputStream fos = new FileOutputStream(path+"/"+fname);
					fos.write(date);
					fos.close();
				
					//원래 게시물의 첨부파일이 있었다면 원래 파일을 삭제함
					if(oldFname!=null&&!oldFname.equals("")) {
						File file = new File(path+"/"+oldFname);
						file.delete();
					}
				} catch (Exception e) {}
			}
		}else {
			mav.setViewName("error");
			mav.addObject("msg", "게시판수정에 실패했습니다");
		}
		return mav;
	}
	@RequestMapping(value = "/deleteBoard",method = RequestMethod.GET)
	public void deleteForm(int no,Model model) {
		model.addAttribute("no", no);
	}
	
	@RequestMapping(value = "/deleteBoard",method = RequestMethod.POST)
	public ModelAndView deleteSubmit(int no,String pwd,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		String oldFname = dao.findByNo(no).getFname();
		
		
		HashMap map = new HashMap();
		map.put("no", no);
		map.put("pwd", pwd);
		int re = dao.delete(map);
		if(re == 1) {
			if(oldFname != null && !oldFname.equals("")) {
				String path = request.getRealPath("images");
				File file = new File(path+"/"+oldFname);
				file.delete();
			}
		}else {
			mav.setViewName("error");
			mav.addObject("msg", "게시물 삭제에 실패하였습니다");
		}
		
		return mav;
	}
}
