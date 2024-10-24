package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mapper.T_TestMapper;
import com.test.spring.dto.T_TestDto;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class T_TestServiceImpl implements T_TestService {
	
	@Setter(onMethod_ = @Autowired)
	private T_TestMapper mapper;
	
	public String getOne() {
		log.info("test====");
		T_TestDto tvo = mapper.getData1();
		String one = tvo.getStr_data();
		return one;
	}
	
	public String getTwo() {
		log.info("test====");
		T_TestDto tvo = mapper.getData2();
		String two = tvo.getStr_data();
		return two;
	}
	
	public String getThree() {
		log.info("test====");
		T_TestDto tvo = mapper.getData3();
		String three = tvo.getStr_data();
		return three;
	}
	
	public String getFour() {
		log.info("test====");
		T_TestDto tvo = mapper.getData4();
		String four = tvo.getStr_data();
		return four;
	}
	
	
	public void update() {
		mapper.updateVisitantCount();
	}
	
	public void insert() {
		mapper.insertDoodle();
	}
	
	public void del() {
		mapper.delTest();
	}
	
}
