package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		
		//스프링컨테이너 factory = new 스프링컨테이너();
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// 컨테이너를 구동시키는 코드
		
		
	
		//Phone phone = factory야.폰객체좀("아이폰");
		Phone phone = (Phone)factory.getBean("apple");
		Phone phone01 = (Phone)factory.getBean("samsung");
		
		
		//Phone phone = new GalaxyPhone();
		// Bean == 자바객체 == 객체 == POJO
		// 객체를 요청하다.
		// == look up
		phone.powerOn();
		phone.powerOff();
		phone01.powerOn();
		phone01.powerOff();
//		
//		Phone p1 = (Phone)factory.getBean("samsung");
//		Phone p2 = (Phone)factory.getBean("samsung");
//		Phone p3 = (Phone)factory.getBean("samsung");
//		p1.powerOn();
//		p2.powerOn();
//		p3.powerOn();
		
		
//		Watch watch = (Watch) factory.getBean("aw");
//		
//		watch.powerOn();
//		watch.powerOff();
		
		factory.close(); // 안정성을 위해 적음
	}

}
