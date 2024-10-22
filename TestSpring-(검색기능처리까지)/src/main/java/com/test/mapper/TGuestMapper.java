package com.test.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.test.dto.Dto;
import com.test.dto.TGuestDto;

public interface TGuestMapper {
	public ArrayList<TGuestDto> getList(int limitIndex);
	public int getPostCount();
	public TGuestDto read(long bno);
	public void del(long bno);
	public void write(TGuestDto dto);
	public void modify(TGuestDto dto);
	
	public ArrayList<TGuestDto> getSearchList(Dto d);
	public int getSearchPostCount(String word);
	
	
//@Param 어노테이션 이용방식	
//	 public ArrayList<TGuestDto> getSearchList(@Param("word") String word, @Param("limitIndex") int limitIndex);
//	 public int getSearchPostCount(@Param("word") String word);
}
