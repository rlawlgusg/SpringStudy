package com.sist.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.db.DBManager;
import com.sist.vo.DeptVO;

@Repository
public class DeptDao {
	public List<DeptVO> list(){
		return DBManager.list();
	}
	
	public DeptVO getDept(int dno) {
		return DBManager.getDept(dno);
	}
	
	public int insertDept(DeptVO d) {
		return DBManager.insert(d);
	}
	
	public int updateDept(DeptVO d) {
		return DBManager.update(d);
	}
	
	public int deleteDept(int dno) {
		return DBManager.delete(dno);
	}
}
