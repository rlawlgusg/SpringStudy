package com.example.demo.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.GoodsVO;


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
	
	public static int getTotalRecord(HashMap map) {
		SqlSession session = factory.openSession();
		int count = session.selectOne("goods.totalRecord",map);
		session.close();
		return count;
	}
	
	public static List<GoodsVO> findAll(HashMap map){
		SqlSession session = factory.openSession();
		List<GoodsVO> list = session.selectList("goods.findAll",map);
		session.close();
		return list;
	}
	
	public static int insert(GoodsVO g) {
		SqlSession session = factory.openSession();
		int re = session.insert("goods.insert", g);
		session.commit();
		session.close();
		return re;
	} 
	
	public static GoodsVO detail(int no){
		SqlSession session = factory.openSession();
		GoodsVO g = session.selectOne("goods.detail", no);
		session.close();
		return g;
	}
	
	public static int update(GoodsVO g) {
		SqlSession session = factory.openSession();
		int re = session.update("goods.update", g);
		session.commit();
		session.close();
		return re;
	}
	
	public static int delete(int no) {
		SqlSession session = factory.openSession();
		int re = session.delete("goods.delete", no);
		session.commit();
		session.close();
		return re;
	}
	
	
}
