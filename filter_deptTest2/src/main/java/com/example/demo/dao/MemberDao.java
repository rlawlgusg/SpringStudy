package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.MemberVO;

@Repository
public class MemberDao {
	
	public int isMember(String id,String usrPwd) {
		
		String dbPwd = DBManager.isMember(id);
		int re = -1;
		if(dbPwd == null) {
			re = -1;
		}else {
			if(usrPwd.equals(dbPwd)) {
				re = 1;
			}else {
				re = 0;
			}
		}
		return re;
	}
	
	public String getRole(String id) {
		return DBManager.getRole(id);
	}
}
