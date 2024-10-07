package com.yn.app.view.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.yn.app.biz.board.BoardDAO;
import com.yn.app.biz.board.BoardDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardController implements Controller{
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 사용자(클라이언트, 브라우저)가 보낸 파라미터에서 값 추출
		BoardDTO data = new BoardDTO();
		String board_title = request.getParameter("title");
		String board_content = request.getParameter("content");
		// 2. DB 연동
		data.setBoard_title(board_title);
		data.setBoard_content(board_content);
		
		// 3. 페이지 이동 == 네비게이션
		ModelAndView mav = new ModelAndView();
		if(!boardDAO.insert(data)) {
			mav.setViewName("error.jsp");
			// insert 실패했다면
		}
		else {			
			mav.setViewName("main.do"); // 작성 후 이동할 페이지
		}
		return mav;
	}

}
