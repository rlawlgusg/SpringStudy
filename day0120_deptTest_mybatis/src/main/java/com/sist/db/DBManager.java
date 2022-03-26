package com.sist.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

public class DBManager {
	
	//mybatis �������Ͽ� �����ϱ� ���� sqlSessionFactory ������ ����
	//�� ������ ��ü ���� ���ٰ����ϵ��� static������ ����
	private static SqlSessionFactory sqlMapper;
	
	//���α׷� ����� ���ÿ� �ڵ����� ����Ǿ� 
	//mybatis ���������� �о� ���̱� ���Ͽ� static ���� �ڵ�
	static {
		try {
			//������ �о�� �ϱ� ������ ���� ó��
			Reader reader = Resources.getResourceAsReader("com/sist/db/sqlMapConfig.xml");
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
	
	//mybatis ���������� Ư�� sql(dept��� ���ӽ����̽��� selectAll�̶�� id�� ����)�� ��û�ϴ� �޼ҵ带 ������
	public static List<DeptVO> list(){

		//mybatis �������Ͽ� �ִ� sql�� ����ϱ� ���Ͽ�
		//SqlSessionFactory�� ���Ͽ� SqlSession��ü�� ����
		SqlSession session = sqlMapper.openSession();
		//sqlSession�� ���� sql�� ������
		//sqlSession���� crud�� ���� insert,update,delete,select �޼ҵ� ���� ����
		//������ selectList�� �̿���
		//�̶��� �Ű������� mybatis���� ���Ͽ� �ִ� ���ӽ����̽�(dept)�� id(selectAll)�� ��������
	    List<DeptVO> list = session.selectList("dept.selectAll");
	    //session�� ����� �Ŀ��� session�� �ݾ���
	    session.close();

	    return list;
	}
	
	public static DeptVO getDept(int dno) {
		SqlSession session = sqlMapper.openSession();
		DeptVO d = session.selectOne("dept.selectDept", dno);
		session.close();
		return d;
	}
	
	public static int insert(DeptVO d) {
		int re = -1;
		SqlSession session = sqlMapper.openSession();
		re = session.insert("dept.insert", d);
		//�����ͺ��̽��� ������ �ִ� sql(insert,update,delete)�� ������ ������ �ݵ��
		//session.commit()�̰ų� rollback() �޼ҵ带 ȣ���ؾ� ��
		if(re == 1) {
			session.commit();
		}
		session.close();
		return re;
	}
	public static int update(DeptVO d) {
		int re = -1;
		SqlSession session = sqlMapper.openSession(true);
		re = session.update("dept.update", d);
		//session.commit();
		session.close();
		return re;
	}
	public static int delete(int dno) {
		int re = -1;
		SqlSession session = sqlMapper.openSession(true);
		re = session.delete("dept.delete", dno);
		//session.commit();
		session.close();
		return re;
	}
	
	public static List<EmpVO> listEmp(){
		SqlSession session = sqlMapper.openSession();
		List<EmpVO> list = session.selectList("emp.selectAll");
		session.close();
		return list;
	}
	
}
