package com.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class T_TestServiceTests {
	
	@Setter(onMethod_ = @Autowired) 
	private T_TestService service;
	
	@Test
	public void testService() {
		String s1 = service.getOne();
		String s2 = service.getTwo();
		String s3 = service.getThree();
		String s4 = service.getFour();
		int n1 = Integer.parseInt(s1);
		int n2 = Integer.parseInt(s2);
		int n3 = Integer.parseInt(s3);
		int sum = n1+n2+n3;
		log.info("(서비스 테스트) 1+2+100은===:"+sum);
		log.info("(서비스 테스트) 4===:"+s4);
	}
}
