package com.yn.app.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.yn.app.biz..*Impl.*(..))")
	public void logPointcut() {} // 참조 메서드
	
	@Pointcut("execution(* com.yn.app.biz..*Impl.select*(..))")
	public void rolePointcut() {}
	
	@Pointcut("execution(* com.yn.app.biz..BoardServiceImpl.insert(..))")
	public void boardPointcut() {}

	// 서비스의 모든 메서드에 대한 포인트컷 (CUD 작업 처리용)
    @Pointcut("execution(* com.yn.app.biz..*ServiceImpl.*(..))")
    public void serviceMethods() {}

    // CUD 작업에 대한 포인트컷
    @Pointcut("execution(* com.yn.app.biz..*Impl.*(..)) && !execution(* com.yn.app.biz..*Impl.select*(..))")
    public void cudMethods() {}
    
    // R 작업 중 selectAll 메서드에 대한 포인트컷
    @Pointcut("execution(java.util.List com.yn.app.biz..*Impl.select*(..))")
    public void selectAllMethods() {}
    
    // DTO 반환 메서드에 대한 포인트컷 (SELECT 작업 중 DTO 반환)
    @Pointcut("execution(com.yn.app.biz..*DTO com.yn.app.biz..*Impl.select*(..))")
    public void selectReturnDTO() {}
        
	// pointcut은 메모리를 차지하지 않음.
	// 참조용 메서드기 때문에 실제로 동작하지 않기 때문에 (== new 대상이 아니기 때문에,)
	// @Service 안 붙임
}
