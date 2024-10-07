package com.yn.app.view.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.yn.app.biz.member.MemberDAO;
import com.yn.app.biz.member.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class LoginController implements Controller{
	@Autowired // dao 의존 주입, dao에는 @repository 확인하기!
	private MemberDAO memberDAO;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 사용자(클라이언트, 브라우저)가 보낸 파라미터에서 값 추출
		String mid = request.getParameter("mid");
		String password = request.getParameter("password");

		// 2. DB 연동
		// dao는 new 지양.. 의존주입 하자
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMember_id(mid);
		memberDTO.setMember_password(password);
		memberDTO = memberDAO.SelectOne(memberDTO);

		// 3. 페이지 이동 == 네비게이션
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		if(memberDTO != null) {
			mav.addObject("userId", memberDTO.getMember_id());
			mav.setViewName("main.do");
		}
		return mav;
	}
}
