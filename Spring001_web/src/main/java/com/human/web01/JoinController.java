package com.human.web01;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.human.service.IF_joinService;
import com.human.vo.MemberVO;

@Controller
public class JoinController {

	@Inject
	private IF_joinService jsr;

	@RequestMapping(value = "/joinAction", method = RequestMethod.POST)
	public String joinAction(Locale locale, Model model, MemberVO mvo) throws Exception {
		System.out.println(mvo.getId() + "--디버깅체크");
		jsr.insertOne(mvo);
		return "redirect:/";
	}

	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinAction(Locale locale, Model model) {
		return "join/joinForm";
	}

	@RequestMapping(value = "/memList", method = RequestMethod.GET)
	public String wrAction(Locale locale, Model model) throws Exception {
		List<MemberVO> list = jsr.selectAll();
		System.out.println(list.size() + "---디버깅확인");
		model.addAttribute("mList", list);
		return "list/memList";
	}

	@RequestMapping(value = "/memberView", method = RequestMethod.GET)
	public String memberView(Locale locale, Model model, HttpServletRequest request) throws Exception {
		String id = request.getParameter("mid");
		System.out.println(id + "---디버깅---");
		MemberVO mvo = jsr.selectOne(id);
		model.addAttribute("member", mvo);
		return "list/memberView";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String memberDelete(Locale locale, Model model, HttpServletRequest request) throws Exception {
		String id = request.getParameter("mid");
		System.out.println(id + "---디버깅---");
		jsr.deleteOne(id);
		return "redirect:/memList";
	}

	@RequestMapping(value = "/modiForm", method = RequestMethod.GET)
	public String modiForm(Locale locale, Model model, HttpServletRequest request) throws Exception {
		String id = request.getParameter("mid");
		System.out.println(id + "---디버깅---");
		MemberVO mvo = jsr.selectOne(id);
		model.addAttribute("member", mvo);
		return "join/modiForm";
	}

	@RequestMapping(value = "/modiAction", method = RequestMethod.POST)
	public String modiAction(Locale locale, Model model, HttpServletRequest request, MemberVO mvo) throws Exception {
		System.out.println(mvo.getId() + "---디버깅---");
		jsr.updateOne(mvo);
		// model.addAttribute("member",mvo);
		return "redirect:/memList";
	}

}
