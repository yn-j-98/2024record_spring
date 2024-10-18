package com.yn.app.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	// reading처리에 대한 시점 어노테이션
	@Before("PointcutCommon.logPointcut()")
	public void printLog() {
		System.out.println("공통 관심 - 로그 : 비즈니스 메서드 수행 전에 호출됨");
	}

}
