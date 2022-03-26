package com.example.test0315.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test0315.dao.DeptDAO;
import com.example.test0315.vo.DeptVO;

import lombok.Setter;

@Service
@Setter
public class DeptService {
	
	@Autowired
	private DeptDAO dao;
	//select * from dept
	public List<DeptVO> findAll(){
		return dao.findAll();
	}
	
	//update dept set dname=?,dloc=? where dno=? 		:   만약에 dno가 있으면 
	//insert into dept(dno,dname,dloc) values (?,?,?)	: 	만약에 dno가 없으면
	public void save(DeptVO d) {
		dao.save(d);	//insert를 이해서 save메소드를 호출함
	}
	
	//select * from dept where dno = ?
	public DeptVO getDept(int dno) {
		return dao.getOne(dno);
	}
	
	//delete dept where dno = ?
	public void delete(int dno) {
		dao.deleteById(dno);
	}
	
	
}
