package com.test.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.spring.dto.T_TestDto;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class T_TestMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private T_TestMapper mapper;
	
	@Test
	public void testGetList() {
		T_TestDto sData1 = mapper.getData1();
		T_TestDto sData2 = mapper.getData2();
		T_TestDto sData3 = mapper.getData3();
		T_TestDto sData4 = mapper.getData4();
		log.info(sData1);
		log.info(sData2);
		log.info(sData3);
		log.info(sData4);
		String s1 = sData1.getStr_data();
		String s2 = sData2.getStr_data();
		String s3 = sData3.getStr_data();
		String s4 = sData4.getStr_data();
		int n1 = Integer.parseInt(s1);
		int n2 = Integer.parseInt(s2);
		int n3 = Integer.parseInt(s3);
		int sum = n1+n2+n3;
		log.info("1+2+100 은 ===:"+sum);
		log.info("4는:"+s4);
	}
}
