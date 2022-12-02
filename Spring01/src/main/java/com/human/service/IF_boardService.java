package com.human.service;

import java.util.List;

import com.human.vo.BoardVO;
import com.human.vo.PageVO;

public interface IF_boardService {
	
	//여기서 정의한 메서드는 컨트롤러에서 호출하는 메서드이다. 
	//구현은 dao를 호출하는 메서드가 있을 것이다. 이름을 동일하게 쓰는 이유는 가독성때문.
	//그래서 컨트롤러<> 서비스 <> dao를 먼저 이해하고 이 기반에서 가독성을 이해해야 한다. 
	
	public void insertOne(BoardVO boardvo) throws Exception;
				//컨트롤러에서 호출할 메서드
	
	public List<BoardVO> selectAll(PageVO pageVO) throws Exception;
							//selectAll()는 컨트롤러에서 접근하기위한 메서드
	public int countBoard() throws Exception;
	
	public BoardVO selectOne(String vno) throws Exception;
	
	public List<String> selectAttach(String vno) throws Exception;
	
	public void updatecnt(String vno) throws Exception;
	
	public void boardDel(String vno) throws Exception;
	
	public void updateBoard(BoardVO boardvo) throws Exception;
}
