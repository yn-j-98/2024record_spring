package com.koreait.app.view.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.app.biz.member.MemberDAO;
import com.koreait.app.biz.member.MemberDTO;
import com.koreait.app.biz.member.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(HttpSession session, MemberDAO memberDAO, MemberDTO memberDTO) {
																// 커맨드 객체
		memberDTO = memberService.selectOne(memberDTO);
		
		String viewName="redirect:login.do";
		if(memberDTO != null) {
			session.setAttribute("userID", memberDTO.getMid());
			viewName = "redirect:main.do";
		}
		return viewName;
	}	
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("userID");
		return "redirect:login.do";
	}
}
