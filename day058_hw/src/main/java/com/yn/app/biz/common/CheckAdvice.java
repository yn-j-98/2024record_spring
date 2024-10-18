package com.yn.app.biz.common;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.yn.app.biz.member.MemberDTO;


@Service
@Aspect
public class CheckAdvice {
	
	@AfterReturning(pointcut="PointcutCommon.rolePointcut()", returning="returnObj")
	public void check(Object returnObj) {
		if(returnObj instanceof MemberDTO) {
			MemberDTO memberDTO = (MemberDTO)returnObj;
			if (memberDTO.getRole() != null && memberDTO.getRole().equals("USER")) {
			    System.out.println("회원이 로그인했습니다.");
			} else if (memberDTO.getRole() != null) {
			    System.out.println("관리자가 로그인했습니다.");
			} else {
			    System.out.println("ROLE 값이 없습니다.");
			}
		}
	}

}
