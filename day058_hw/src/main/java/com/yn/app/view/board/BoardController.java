package com.yn.app.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yn.app.biz.board.BoardDTO;
import com.yn.app.biz.board.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/main.do")
	public String main(BoardDTO boardDTO, Model model) {
		//model == 데이터 전달하는 역할
		System.out.println("BoardController main 메서드 도착"+boardDTO);
		List<BoardDTO> datas=boardService.selectAll(boardDTO);
		model.addAttribute("datas", datas);
		System.out.println("datas ["+datas+"]");
		return "main";
	}
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public String insertBoard() {
		return "insertBoard";
	}
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(BoardDTO boardDTO) {
		boolean flag=boardService.insert(boardDTO); // weaving 처리 대상
		System.out.println("insertBoard ["+flag+"]");
		return "redirect:main.do";
	}
	
	
}
