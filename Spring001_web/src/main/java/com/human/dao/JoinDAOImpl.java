package com.human.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.vo.MemberVO;

@Repository
public class JoinDAOImpl implements IF_joinDAO{
	
	@Inject
	private static String mapperQuery = "com.human.dao.IF_joinDAO";
	
	@Inject
	private SqlSession sqlsession;

	@Override
	//회원가입
	public void insertOne(MemberVO mvo) throws Exception {
		sqlsession.insert(mapperQuery + ".insertOne",mvo);		
	}

	@Override
	//회원 전체보기
	public List<MemberVO> selectAll() throws Exception {
		return sqlsession.selectList(mapperQuery + ".selectAll");		
	}
	
	@Override 
	//회원 자세히보기
	public MemberVO selectOne(String id) throws Exception {	  
		return sqlsession.selectOne(mapperQuery +".selectOne", id); 
	}

	@Override
	//회원 삭제하기
	public void deleteOne(String id) throws Exception {
		sqlsession.delete(mapperQuery + ".deleteOne",id);		
	}

	@Override
	//회원 수정하기
	public void updateOne(MemberVO mvo) throws Exception {
		sqlsession.update(mapperQuery + ".updateOne",mvo);		
	}
	 
	
}
