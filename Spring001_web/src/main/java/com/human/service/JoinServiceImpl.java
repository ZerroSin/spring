package com.human.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.dao.IF_joinDAO;
import com.human.vo.MemberVO;

@Service
public class JoinServiceImpl implements IF_joinService {
	
	@Inject
	private IF_joinDAO jdao;
	
	@Override
	//회원가입
	public void insertOne(MemberVO mvo) throws Exception {		
		if(mvo.getGrade().equals("vip")) {
			mvo.setPoint(1000);
			jdao.insertOne(mvo);			
		}else {
			jdao.insertOne(mvo);
		}
	}

	@Override
	//회원 전체보기
	public List<MemberVO> selectAll() throws Exception {		
		return jdao.selectAll();
	}

	@Override
	//회원 자세히보기
	public MemberVO selectOne(String id) throws Exception {
		
		return jdao.selectOne(id);
	}

	@Override
	//회원 삭제하기
	public void deleteOne(String id) throws Exception {
		jdao.deleteOne(id);
		
	}

	@Override
	//회원 정보 수정하기
	public void updateOne(MemberVO mvo) throws Exception {
		if(mvo.getGrade().equals("vip")) {
			mvo.setPoint(1000);
			jdao.updateOne(mvo);			
		}else {
			jdao.updateOne(mvo);
		}		
	}

	/*
	 * @Override public List<MemberVO> selectOne() throws Exception { // TODO
	 * Auto-generated method stub return jdao.selectOne(); }
	 */

	
}
