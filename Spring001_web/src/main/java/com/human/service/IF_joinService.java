package com.human.service;

import java.util.List;

import com.human.vo.MemberVO;

public interface IF_joinService {

	public void insertOne(MemberVO mvo) throws Exception;
	
	public List<MemberVO> selectAll() throws Exception;
	
	public MemberVO selectOne(String id) throws Exception;
	
	public void deleteOne(String id) throws Exception;
	
	public void updateOne(MemberVO mvo) throws Exception;
}
