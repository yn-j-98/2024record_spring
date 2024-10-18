package com.yn.app.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class ServiceReturnAdvice {
	
	
    @AfterReturning(pointcut = "PointcutCommon.selectReturnDTO()", returning = "returnObj")
    public void logDTO(JoinPoint jp, Object returnObj) {
    	System.out.println("서비스 기능 반환 발생!");
        System.out.println("메서드명: " + jp.getSignature().getName());
        if (returnObj != null) {
            System.out.println("반환된 DTO: " + returnObj.toString());
        } else {
            System.out.println("반환된 DTO가 없습니다.");
        }
    }
}
