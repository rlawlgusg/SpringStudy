package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.CustomerVO;
//mybatis의 설정파일에 있는 sql을 요청하는 클래스
public class DBManager {
	
	//mybatis 설정파일에 있는 sql을 요청하려면 
	//sqlSession이 필요함
	//이 SqlSession을 만들어주는 SqlSessionFactory 변수를 멤버로 선언함
	//DBManager 객체 없이도 사용할 수 있도록 static으로 만듬!
	private static SqlSessionFactory factory;
	
	//mybatis 설정파일인 sqlMapConfig파일을 읽어 들여 
	//SqlSessionFactory객체를 생성함
	//사용자의 어떤 메소드 요청 없이도 서버가 가동되면서 자동으로 동작하도록 하기 위하여 
	//static 블럭에 내용을 작성함
	//파일의 내용을 읽어들여야 하니 예외처리도 해줌
	static {
		try {
			//mybatis 설정파일인 sqlMapConfig파일을 
			//stream으로 읽어들임(stream:순서있는 자료의 흐름)
			//파일의 내용을 읽고 쓰려면 자료(데이터) 순서 있게 나가고 들어와야 함
			//이것을 "stream"이라고 함
			//환경설정파일이 문자로 되어 있으므로 문자단위의 최상위 스트림인 
			//Reader 객체를 생성함 
			//mybatis 설정파일을 stream으로 읽어오기 위하여
			//mybatis가 제공하는 Resources클래스의 static 메소드인
			//getResourceAsReader 메소드를 이용함
			//이때 매개변수로 설정파일의 경로를 포함한 이름을 전달함
			Reader reader = 
					Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			//위에서 생성한 stream을 매개변수로 하여
			//SqlSessionFactory 객체를 생성함
			factory = new SqlSessionFactoryBuilder().build(reader);
			//사용했던 stream은 닫아줌
			reader.close();
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}	
	}
	//mybatis 설정파일에 등록한 customerMapper파일에 있는 
	//sql중에 모든 고객목록을 검색하는 sql을 요청하는 메소드 정의
	//DBManager 객체를 생성하지 않고 사용할 수 있도록 static메소드로 만듬
	public static List<CustomerVO> findAll(){
		//mybatis 설정파일에 있는 sql을 요청하기 위하여 
		//SqlSessionFactory를 통하여 SqlSession을 얻어와야함
		SqlSession session = factory.openSession();
		//mybatis 설정파일에 있는 sql을 요청함
		//설정파일의 네임스페이스와 아이디를 통해 요청함
		List<CustomerVO> list = session.selectList("customer.findAll");
		//세션의 사용이 끝나면 닫아줌
		session.close();
		return list;
	}
}
