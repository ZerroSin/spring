package com.human.cafe;

import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.human.service.IF_MemberService;
import com.human.service.IF_boardService;
import com.human.vo.BoardVO;
import com.human.vo.MemberVO;

@Controller
public class BbsController {
	@Inject		// 나 서비스단이 필요해 주입해줘
	private IF_boardService bsrv;
	@Inject		// 나 서비스단이 필요해 주입해줘
	private IF_MemberService msrv;
	
	
	@RequestMapping(value = "/joinAction", method = RequestMethod.POST)
	public String joinAction(Locale locale, Model model, MemberVO mvo) throws Exception{
		//객체로 받을 때는 파라미터 이름과 객체의 변수의 이름이 일치하고  getter,setter가 있어야한다.>>자동매핑
		System.out.println(mvo.getName()+"---디버깅용도"); 
		msrv.insertMember(mvo);
		return "home";
	}
	
	@RequestMapping(value = "/wrAction", method = RequestMethod.POST)
	public String wrAction(Locale locale, Model model, BoardVO bvo) throws Exception{
		//객체로 받을 때는 파라미터 이름과 객체의 변수의 이름이 일치하고  getter,setter가 있어야한다.>>자동매핑
		System.out.println(bvo.getName()+"---디버깅용도"); 
		bsrv.insertOne(bvo);
		return "home";
	}
	
	
	@RequestMapping(value = "/wrForm", method = RequestMethod.GET)
	public String wrForm(Locale locale, Model model) {
		
		return "wrForm";
	}
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(Locale locale, Model model) {
		
		return "joinForm";
	}
	
}
