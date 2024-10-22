package com.test.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.test.dto.Dto;
import com.test.dto.TGuestDto;
import com.test.mapper.TGuestMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class TGuestServiceImpl implements TGuestService{

	private TGuestMapper mapper;
	
	public ArrayList<TGuestDto> getList(int currentPage){
		int limitIndex = (currentPage-1)*5;
		return mapper.getList(limitIndex);
	}
	
	public TGuestDto read(long bno) {
		return mapper.read(bno);
	}
	
	public void del(long bno) {
		mapper.del(bno);
	}
	
	public void write(TGuestDto dto) {
		mapper.write(dto);
	}
	
	public void modify(TGuestDto dto) {
		mapper.modify(dto);
	}
	
	public int getPostCount() {
		return mapper.getPostCount();
	}
	
	public ArrayList<TGuestDto> getSearchList(String word,int currentPage){
		int limitIndex = (currentPage-1)*5;
		Dto d = new Dto(word,limitIndex);
		return mapper.getSearchList(d);
	}
	
	public int getSearchPostCount(String word) {
		return mapper.getSearchPostCount(word);
	}
}
