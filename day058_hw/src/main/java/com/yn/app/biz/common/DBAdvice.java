package com.yn.app.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class DBAdvice {

	
    @Before("PointcutCommon.serviceMethods() && !PointcutCommon.selectAllMethods()")
    public void DBaccess() {
        System.out.println("DB 접근 발생!");
    }

    @After("PointcutCommon.cudMethods()")
    public void DBupdate() {
        System.out.println("DB 변경 완료!");
    }
}
