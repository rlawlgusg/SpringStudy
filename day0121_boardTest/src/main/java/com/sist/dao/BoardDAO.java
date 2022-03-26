package com.sist.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.db.DBManager;
import com.sist.vo.BoardVO;

@Repository
public class BoardDAO {
	public List<BoardVO> listAll(){
		return DBManager.listAll();
	}
	public int insert(BoardVO b) {
		return DBManager.insert(b);
	}
}
