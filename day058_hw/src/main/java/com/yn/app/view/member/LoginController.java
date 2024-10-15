package com.yn.app.view.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yn.app.biz.member.MemberDTO;
import com.yn.app.biz.member.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private MemberService memberService;
	
	// 로그인 페이지 이동
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	// 로그인 처리
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(HttpSession session,MemberDTO memberDTO) {
																// 커맨드 객체
		memberDTO.setCondition("SELECTONE_LOGIN");
		memberDTO = memberService.selectOne(memberDTO);
		
		String viewName="redirect:login.do";
		if(memberDTO != null) {
			session.setAttribute("userID", memberDTO.getMid());
			session.setAttribute("userName", memberDTO.getName());
			viewName = "redirect:main.do";
		}
		return viewName;
	}	
	
	// 회원가입 페이지 이동
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		System.out.println("LoginController.java join GET 로그");
		return "join";
	}
	
	// 회원가입 처리
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(MemberDTO memberDTO) {
		System.out.println("LoginController.java join POST 로그");
		memberDTO.setCondition("INSERT");
		boolean flag = memberService.insert(memberDTO);
		System.out.println("C : memberInsert ["+flag+"]");
		return "redirect:login.do";
	}
	
	// 로그아웃 처리
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("userID");
		session.removeAttribute("userName");
		System.out.println("로그아웃 처리 성공");
		return "redirect:login.do";
	}
}
