package com.yn.app.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("board")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardDTO> SelectAll(BoardDTO boardDTO) {
		return this.boardDAO.SelectAll(boardDTO);

	}

	@Override
	public BoardDTO SelectOne(BoardDTO boardDTO) {
		return this.boardDAO.SelectOne(boardDTO);
	}

	@Override
	public boolean insert(BoardDTO boardDTO) {
		return this.boardDAO.insert(boardDTO);

	}

	@Override
	public boolean update(BoardDTO boardDTO) {
		return this.boardDAO.update(boardDTO);

	}

	@Override
	public boolean delete(BoardDTO boardDTO) {
		return this.boardDAO.delete(boardDTO);

	}


	
	
	

}
