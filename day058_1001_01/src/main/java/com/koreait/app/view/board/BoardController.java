package com.koreait.app.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.app.biz.board.BoardDTO;
import com.koreait.app.biz.board.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/main.do")
	public String main(BoardDTO boardDTO, Model model) {
		System.out.println(boardDTO);
		List<BoardDTO> datas=boardService.selectAll(boardDTO);
		model.addAttribute("datas", datas);
		return "main";
	}
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public String insertBoard() {
		return "insertBoard";
	}
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(BoardDTO boardDTO) {
		boolean flag=boardService.insert(boardDTO);
		System.out.println("insertBoard ["+flag+"]");
		return "redirect:main.do";
	}
}
