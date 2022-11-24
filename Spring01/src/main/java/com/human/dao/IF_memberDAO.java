package com.human.dao;


import com.human.vo.MemberVO;

public interface IF_memberDAO {

	public void insertMember(MemberVO membervo) throws Exception;
	//서비스단에서 호출할 메서드 + 매핑에 사용될 메서드

}
