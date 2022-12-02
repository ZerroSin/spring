package com.human.cafe;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.human.service.IF_MemberService;
import com.human.service.IF_boardService;
import com.human.util.FileDataUtil;
import com.human.vo.BoardVO;
import com.human.vo.MemberVO;
import com.human.vo.PageVO;

@Controller
public class BbsController {
	@Inject		// 나 서비스단이 필요해 주입해줘
	private IF_boardService bsrv;
	@Inject		// 나 서비스단이 필요해 주입해줘
	private IF_MemberService msrv;
	@Inject
	private FileDataUtil fileDataUtil;
	
	@RequestMapping(value = "/bbsList", method = RequestMethod.GET)
	public String wrAction(Locale locale, Model model,@ModelAttribute("pageVO") PageVO pageVO) throws Exception{
		//객체로 받을 때는 파라미터 이름과 객체의 변수의 이름이 일치하고  getter,setter가 있어야한다.>>자동매핑
		//System.out.println(bvo.getName()+"---디버깅용도"); 
		//bsrv.insertOne(bvo);
		//page 계산하기위해서는 첫번째 페이지정보(클라이언트가 넘겨준다),두번째 전체페이지수, 세번째 페이지당/ 페이지그룹당 수
		if(pageVO.getPage() == null) {	//클라이언트가 페이지정보를 넘겨주지않는다면 기본값 1로 세팅
			pageVO.setPage(1);
		}
		System.out.println("현재 페이지정보 : " + pageVO.getPage());		
		
		int totalpageCnt = bsrv.countBoard();//select count(*) from board2;
		System.out.println(totalpageCnt+"건 등록됨");
		pageVO.setTotalCount(totalpageCnt);
		System.out.println(pageVO.getStartNo());
		System.out.println(pageVO.getEndNo());
		List<BoardVO> list = bsrv.selectAll(pageVO);	//페이징을 쿼리에 매핑 > 매개변수가 필요
		
		System.out.println(list.size()+"---디버깅확인");
		model.addAttribute("bList",list);
		model.addAttribute("pageVO" , pageVO);	//페이지 객체로 view에게 전달
		return "bbs/bbsList";
	}

	
	@RequestMapping(value = "/wrAction", method = RequestMethod.POST)
	public String wrAction(Locale locale, Model model,BoardVO bvo, MultipartFile[] file) throws Exception{
		//객체로 받을 때는 파라미터 이름과 객체의 변수의 이름이 일치하고  getter,setter가 있어야한다.>>자동매핑
		System.out.println(bvo.getName()+"---디버깅용도"); 
		String[] fileNames = fileDataUtil.fileUpload(file);		
		//System.out.println(file.getOriginalFilename()+"---디버깅용도(파일)"); 
		//filedatautil 객체의 fileupload메서드를 호출.. 매개변수로 file을 넘긴다. << 지정한 폴더(/tmp)로 첨부파일 복사		
		//System.out.println(fileNames[0]+"/"+fileNames[1]+"이 디비에 저장될 파일명.");
		//넘겨받은 파일명을 boardVO files변수에 저장.
		bvo.setFiles(fileNames);
		//DB작업..고고... 
		bsrv.insertOne(bvo);
		return "redirect:/bbsList";
	}
	
	
	@RequestMapping(value = "/wrForm", method = RequestMethod.GET)
	public String wrForm(Locale locale, Model model) {		
		return "bbs/wrForm";
	}
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(Locale locale, Model model) {
		
		return "joinForm";
	}
	
	@RequestMapping(value = "/joinAction", method = RequestMethod.POST)
	public String joinAction(Locale locale, Model model, MemberVO mvo) throws Exception{
		//객체로 받을 때는 파라미터 이름과 객체의 변수의 이름이 일치하고  getter,setter가 있어야한다.>>자동매핑
		System.out.println(mvo.getName()+"---디버깅용도"); 
		msrv.insertMember(mvo);
		return "home";
	}
	
	@RequestMapping(value = "/bbsView", method = RequestMethod.GET)
	public String bbsView(Locale locale, Model model,@RequestParam("vno") String vno) throws Exception{		
		//DB작업
		bsrv.updatecnt(vno);
		BoardVO tempvo = bsrv.selectOne(vno);
		System.out.println(tempvo);
		
		model.addAttribute("boardVO",tempvo);
		List<String> attachList = bsrv.selectAttach(vno);
		model.addAttribute("attachList",attachList);	
		//view 지정
		return "bbs/bbsView";
	}
	
	@RequestMapping(value = "/bbsDel", method = RequestMethod.GET)
	public String bbsDel(Locale locale, Model model,@RequestParam("vno") String vno) throws Exception{
		bsrv.boardDel(vno);
		return "redirect:/bbsList";
	}
	
	
	@RequestMapping(value = "/bbsMod", method = RequestMethod.GET)
	public String bbsMod(Locale locale, Model model,@RequestParam("vno") String vno) throws Exception{
		BoardVO tempvo = bsrv.selectOne(vno);
		System.out.println(tempvo+"---^^---");
		System.out.println(tempvo.getName()+"zzzzzz");
		model.addAttribute("bvo",tempvo);
		return "bbs/bbsmod";
	}
	
	@RequestMapping(value = "/bbsModAction", method = RequestMethod.POST)
	public String bbsModAction(Locale locale, Model model,BoardVO bvo) throws Exception{
		bsrv.updateBoard(bvo);
		return "redirect:/bbsView?vno="+bvo.getNum();
	}
	
	
}
