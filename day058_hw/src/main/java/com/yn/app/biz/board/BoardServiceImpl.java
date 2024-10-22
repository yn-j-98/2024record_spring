package com.yn.app.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO2 boardDAO;

	@Override
	public List<BoardDTO> selectAll(BoardDTO boardDTO) {
		if(boardDTO.getCondition() != null) {
			boardDTO.setKeyword(boardDTO.getKeyword().trim());
		}
		return boardDAO.selectAll(boardDTO);
	}

	@Override
	public BoardDTO selectOne(BoardDTO boardDTO) {
		return boardDAO.selectOne(boardDTO);
	}

	@Override
	public boolean insert(BoardDTO boardDTO) {
		//boardDAO.insert(boardDTO); // 트랜잭션 처리 확인용 코드
		return boardDAO.insert(boardDTO); // 하나의 서비스가 제대로 처리되지않아서, 서비스의 처음 상태로 되돌아감 == ROLLBACK
	}

	@Override
	public boolean update(BoardDTO boardDTO) {
		return boardDAO.update(boardDTO);
	}

	@Override
	public boolean delete(BoardDTO boardDTO) {
		return boardDAO.delete(boardDTO);
	}
}
