package com.test.mapper;

import com.test.spring.dto.T_TestDto;

public interface T_TestMapper {
	public T_TestDto getData1();
	public T_TestDto getData2();
	public T_TestDto getData3();
	public T_TestDto getData4();
	
	public void updateVisitantCount();
	public void insertDoodle();
	public void delTest();
}
