package com.yn.app.biz.common;

import com.yn.app.biz.member.MemberDTO;

public class CheckAdvice {
	public void check(Object returnObj) {
		if(returnObj instanceof MemberDTO) {
			MemberDTO memberDTO = (MemberDTO)returnObj;
			if(memberDTO.getRole().equals("USER")) { // returnObj가 일반회원이면
				System.out.println("회원이 로그인했습니다.");
			}
			else {
				System.out.println("관리자가 로그인했습니다.");
			}
		}
	}

}
