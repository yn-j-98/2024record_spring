package com.yn.app.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.yn.app.biz.board.BoardDTO;


@Service
@Aspect
public class TestAdvice {

	@AfterReturning("PointcutCommon.boardPointcut()")
	public void print(JoinPoint jp) {// (나의 비즈니스 메서드 정보를 줄래?) == 바인드 변수
		System.out.println("현재 이 어드바이스랑 연결된 조인포인트의 메서드");
		System.out.println("== 포인트컷의 메서드명");
		String methodName = jp.getSignature().getName();
		System.out.println(methodName);
		
		System.out.println("현재 이 어드바이스랑 연결된 조인포인트의 매개변수 정보");
		System.out.println("== 포인트컷의 매개변수 정보");
		Object[] args = jp.getArgs(); 
		if(args[0] instanceof BoardDTO) {			
			BoardDTO boardDTO = (BoardDTO)args[0];
			System.out.println(boardDTO.getWriter()+"님이 DB에 글을 등록했습니다");
		}
		
		
	}

}
