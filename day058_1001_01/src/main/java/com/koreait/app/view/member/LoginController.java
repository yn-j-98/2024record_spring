package com.koreait.app.view.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.app.biz.member.MemberDAO;
import com.koreait.app.biz.member.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Controller("login")
public class LoginController {
	
	@RequestMapping(value="/login.do")
	public String login(HttpSession session, MemberDAO memberDAO, MemberDTO memberDTO) throws Exception {
																// 커맨드 객체
		/*
		// 1. 사용자(클라이언트,브라우저)가 보낸 파라미터에서 값 추출
		String mid=request.getParameter("mid");
		String password=request.getParameter("password");

		// 2. DB 연동
		memberDTO.setMid(mid);
		memberDTO.setPassword(password);
		*/
		memberDTO = memberDAO.selectOne(memberDTO);

		// 3. 페이지 이동 == 네비게이션
		if(memberDTO != null) {
			session.setAttribute("userName", memberDTO.getName());
			return "redirect:main.jsp";
		}
		return "redirect:login.jsp";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("userName");
		return "redirect:login.jsp";
	}
}
