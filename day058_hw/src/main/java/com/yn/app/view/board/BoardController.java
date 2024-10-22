package com.yn.app.view.board;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.yn.app.biz.board.BoardDTO;
import com.yn.app.biz.board.BoardService;
import com.yn.app.biz.image.ImageDTO;
import com.yn.app.biz.image.ImageService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private ImageService imageService;
	private final String PATH="C:\\YN\\workspace03\\day058_hw\\src\\main\\webapp\\images\\";
	
	@RequestMapping(value="/main.do")
	public String main(BoardDTO boardDTO, Model model) {
		//model == 데이터 전달하는 역할
		System.out.println("BoardController main 메서드 도착"+boardDTO);
		List<BoardDTO> datas=boardService.selectAll(boardDTO);
		model.addAttribute("datas", datas);
		System.out.println("datas ["+datas+"]");
		return "main";
	}
	
	@RequestMapping(value="/board.do")
	public String board(BoardDTO boardDTO, ImageDTO imageDTO, Model model) {
		BoardDTO data=boardService.selectOne(boardDTO);
		model.addAttribute("data", data);
		
		imageDTO=imageService.selectOne(imageDTO);
		if(imageDTO!=null) {
			model.addAttribute("path", imageDTO.getPath());
		}
		return "board";
	}
	@RequestMapping(value="/updateBoard.do")
	public String imageUpload(ImageDTO imageDTO) throws IllegalStateException, IOException {
		System.out.println(imageDTO);
		
		MultipartFile file = imageDTO.getFile();
		String fileName = file.getOriginalFilename();
		System.out.println("파일명 "+fileName);
		
		file.transferTo(new File(PATH+fileName));
		
		imageDTO.setPath(fileName);
		imageService.insert(imageDTO);
		
		return "redirect:main.do";
	}
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public String insertBoard() {
		return "insertBoard";
	}
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(BoardDTO boardDTO) {
		boolean flag=boardService.insert(boardDTO); // weaving 처리 대상
		System.out.println("insertBoard 결과"+flag);
		return "redirect:main.do";
	}
	
	
}
