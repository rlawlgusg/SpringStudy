package com.example.demo.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.DeptVO;
import com.example.demo.vo.MemberVO;

public class DBManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = 
					Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	public static List<DeptVO> findAll(){
		SqlSession session = factory.openSession();
		List<DeptVO> list = session.selectList("dept.findAll");
		session.close();
		return list;
	}
	
	public static int insert(DeptVO d) {
		SqlSession session = factory.openSession();
		int re = session.insert("insert", "dept.insert");
		session.close();
		return re;
	}
	
	public static String isMember(String id) {
		SqlSession session = factory.openSession();
		String pwd = session.selectOne("member.isMember", id);
		session.close();
		return pwd;
	}
	
	public static String getRole(String id) {
		SqlSession session = factory.openSession();
		String role = session.selectOne("member.getRole", id);
		session.close();
		return role;
	}
	
	
}