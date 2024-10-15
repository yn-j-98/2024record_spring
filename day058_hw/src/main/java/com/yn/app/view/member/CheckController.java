package com.yn.app.view.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yn.app.biz.member.MemberDTO;
import com.yn.app.biz.member.MemberService;

@RestController
public class CheckController {
	
	@Autowired
	private MemberService memberService;
	
	// 데이터 1개 받기
	@RequestMapping(value="/checkMID.do", method=RequestMethod.POST)
	public @ResponseBody String checkMID(MemberDTO memberDTO) {
		System.out.println("비동기 처리 로그"); // 잘 도착 했는지 로그
		memberDTO.setCondition("SELECTONE_IDCHECK");
		memberDTO = memberService.selectOne(memberDTO);
		
		String result = "false";  // 변수 선언했다고 그닥 무겁지도 않고, 메서드 내에서 선언 >> 메서드 종료시 사라짐. 메모리 ㄱㅊ
		if(memberDTO != null) { // 데이터가 있다면
			result ="true";
		}
		return result;
	}
	
	
//	//데이터 여러개 받기
//	@RequestMapping(value="/check.do", method=RequestMethod.POST)
//	public @ResponseBody List<String> check(@RequestBody MemberDTO memberDTO) {
//		//@RequestBody 어노테이션을 붙임으로써,
//		//주고받는 data 형식이 json임을 알 수 있다.
//		System.out.println("비동기 처리 로그"); // 잘 도착 했는지 로그
//		
//		memberDTO = memberService.selectOne(memberDTO);
//		
//		List<String> result = new ArrayList<String>();  // 변수 선언했다고 그닥 무겁지도 않고, 메서드 내에서 선언 >> 메서드 종료시 사라짐. 메모리 ㄱㅊ
//		result.add("apple");
//		result.add("banana");
//		return result;
//	}
}
