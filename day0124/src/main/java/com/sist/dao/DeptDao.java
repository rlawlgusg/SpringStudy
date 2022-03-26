package com.sist.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.db.DBManager;
import com.sist.vo.DeptVO;

@Repository
public class DeptDao {
	public List<DeptVO> findAll(){
	return DBManager.findAll();
	}
}
