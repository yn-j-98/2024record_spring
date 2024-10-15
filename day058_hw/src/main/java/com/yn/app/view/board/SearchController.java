package com.yn.app.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yn.app.biz.board.BoardDTO;
import com.yn.app.biz.board.BoardService;

@RestController
public class SearchController {


	@Autowired
	private BoardService boardService;

	//데이터 여러개 받기
	@RequestMapping(value="/search.do", method=RequestMethod.POST)
	public @ResponseBody List<BoardDTO> search(@RequestBody BoardDTO boardDTO) {
		//@RequestBody 어노테이션을 붙임으로써,
		//주고받는 data 형식이 json임을 알 수 있다.
		System.out.println("SearchController 비동기 처리 로그"); // 잘 도착 했는지 로그
		System.out.println("boardDTO 값 ["+boardDTO+"]");
		System.out.println("condition: " + boardDTO.getCondition());
		System.out.println("keyword: " + boardDTO.getKeyword());
		// 검색 조건에 따라 BoardService에서 데이터 가져오기
		// 변수 선언했다고 그닥 무겁지도 않고, 메서드 내에서 선언 >> 메서드 종료시 사라짐. 메모리 ㄱㅊ
		List<BoardDTO> datas = boardService.selectAll(boardDTO);
		System.out.println("List<BoardDTO> datas 값 ["+datas+"]");
		// 검색 데이터들 나오게 해줘
		return datas;
	}


}
