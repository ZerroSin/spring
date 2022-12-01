package com.human.dao;

import java.util.List;

import com.human.vo.BoardVO;
import com.human.vo.PageVO;

public interface IF_boardDAO {
	
	public void insertOne(BoardVO boardvo) throws Exception;
	//서비스단에서 호출할 메서드 + 매핑에 사용될 메서드
	
	public List<BoardVO> selectAll(PageVO pageVO) throws Exception;
	
	public int countBoard() throws Exception;
	
	public void insertAttach(String filename) throws Exception;
	
	public BoardVO selectOne(String vno) throws Exception;
	
	public List<String> selectAttach(String vno) throws Exception;
}
