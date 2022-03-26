package com.sist.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.DeptVO;

public class DBManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = 
					Resources.getResourceAsReader("com/sist/db/sqlMapConfig.xml");
			
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
	
	public  static List<DeptVO> findAll(){
		SqlSession session = factory.openSession();
	   List<DeptVO> list = session.selectList("dept.findAll");
	   session.close();
	   return list;
	}
}
