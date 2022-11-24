package com.human.service;

import com.human.vo.MemberVO;

public interface IF_MemberService {
	
	public void insertMember(MemberVO membervo) throws Exception;//컨트롤러에서 호출할 메서드
}
