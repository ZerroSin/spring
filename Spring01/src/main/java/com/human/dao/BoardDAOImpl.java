package com.human.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.vo.BoardVO;

@Repository  //dao단임을 알려준다.
public class BoardDAOImpl implements IF_boardDAO{
	//spring의 dao와 Mybatis의 sqlsession을 연결하는 객체
	private static String mapperQuery = "com.human.dao.IF_boardDAO"; //매핑하기위한 인터페이스 경로 설정
	
	//mybatis의 sqlSession객체 필요
	@Inject		//나 mybatis가 필요해 주입해줘	
	//스프링컨테이너에서 객체를 가져와야한다. 컨테이너에서 자료형과 맞는 객체의 주소를 주입해준다.	
	private SqlSession sqlSession;	//SqlSession타입의 객체는 스프링컨테이너에 있다.
									//여기서 이 객체가 필요하다. 그런데 컨테이너에서 가져와야한다.
									//스프링은 DI개념
	
	@Override
	public void insertOne(BoardVO boardvo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(mapperQuery + ".insertOne",boardvo); //쿼리 매핑 및 실행
			   //<insert>//매핑정보              //id지정	   //파라미터
	}

}
