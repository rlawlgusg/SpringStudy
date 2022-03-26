package com.example.demo.dao;

import com.example.demo.db.DBManager;

public class SistLogDAO {
	
	public int insert(SistLog log) {
		return DBManager.insertLog(log);
	}
}
