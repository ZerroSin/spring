package com.human.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.dao.IF_boardDAO;
import com.human.vo.BoardVO;

@Service   //넌 서비스단이야
public class BoardServiceImpl implements IF_boardService{
	
	@Inject	//나 dao단이 필요해 주입해줘
	private IF_boardDAO boarddao;
	@Override
	public void insertOne(BoardVO boardvo) throws Exception{ 
		boarddao.insertOne(boardvo);
	}
}
