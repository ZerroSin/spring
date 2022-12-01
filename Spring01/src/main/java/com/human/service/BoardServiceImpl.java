package com.human.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.dao.IF_boardDAO;
import com.human.vo.BoardVO;
import com.human.vo.PageVO;

@Service   //넌 서비스단이야
public class BoardServiceImpl implements IF_boardService{
	
	@Inject	//나 dao단이 필요해 주입해줘
	private IF_boardDAO boarddao;
	@Override
	public void insertOne(BoardVO boardvo) throws Exception{ 
		//board table에 insert
		//board_attach table insert
		boarddao.insertOne(boardvo);
		String [] fname= boardvo.getFiles();
		if(fname != null) {
			for(int i = 0 ; i < fname.length; i++) {
				if(fname[i]!=null) {
					boarddao.insertAttach(fname[i]);
				}				
			}
		}
	}
	@Override
	public List<BoardVO> selectAll(PageVO pageVO) throws Exception {
		//공사중
		return boarddao.selectAll(pageVO);
	}
	@Override
	public int countBoard() throws Exception {
		// TODO Auto-generated method stub
		return boarddao.countBoard();
	}
	@Override
	public BoardVO selectOne(String vno) throws Exception {
		// TODO Auto-generated method stub
		return boarddao.selectOne(vno);
	}
	@Override
	public List<String> selectAttach(String vno) throws Exception {
		// TODO Auto-generated method stub
		return boarddao.selectAttach(vno);
	}
}
