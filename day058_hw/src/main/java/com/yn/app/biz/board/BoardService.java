package com.yn.app.biz.board;

import java.util.List;

public interface BoardService {
	List<BoardDTO> SelectAll(BoardDTO boardDTO);
	BoardDTO SelectOne(BoardDTO boardDTO);
	boolean insert(BoardDTO boardDTO);
	boolean update(BoardDTO boardDTO);
	boolean delete(BoardDTO boardDTO);
	

}
