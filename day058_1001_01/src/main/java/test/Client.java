package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// 컨테이너를 구동시키는 코드
		
		//Phone phone = (Phone)factory.getBean("apple");
		Phone phone1 = (Phone)factory.getBean("samsung");
		// Bean == 자바객체 == 객체 == POJO
		// 객체를 요청하다.
		// == look up
		
//		phone.powerOn();
//		phone.powerOff();
		phone1.powerOn();
		phone1.powerOff();
		
		factory.close(); // 안정성
		
	}
}
