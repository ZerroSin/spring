package com.human.cafe;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserLogin {
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpSession session,
			  			@RequestParam("id") String id,
			  			@RequestParam("pass") String pass) {
		//로그인 절차
		//1. 파라미터 받는다 2.쿼리 실행 후 결과값에 따라 판단 > 서비스단 필요
		//<--------------현재 테스트용으로 하겠다~
		if(id.equals("ttt")) {	//쿼리 실행 후 아이디와 패스워드가 정상적인 경우 리턴받는 것으로 수정
			//로그인 성공 세션처리
			if(session.getAttribute("login") != null ) {
				session.removeAttribute("login");	//일종의 초기화, 굳이 할 필요없지만 한번 더 청소하고 가겠다는 뜻	
			}
			session.setAttribute("login", id); 	  //세션처리
			session.setAttribute("grade", "vip"); //처리하고싶은 변수를 선택하여 등록, 객체/리스트도 가능			
		}else {
			//로그인 실패인 경우
		}
		//테스트용 나중에 DB연동해야됨------------>
		
		System.out.println("로그인 공사중");
		return "home";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)	//로그아웃
	public String login(HttpSession session) {
		session.invalidate();  //세션을 무력화시키는 메서드 (방 빼겠다)
		return "home";
	}
}
