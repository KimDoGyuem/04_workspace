package com.test.service;

import java.util.ArrayList;

import com.test.dto.TGuestDto;

public interface TGuestService {
	public ArrayList<TGuestDto> getList(int currentPage);
	public int getPostCount();
	public TGuestDto read(long bno);
	public void del(long bno);
	public void write(TGuestDto dto);
	public void modify(TGuestDto dto);
	
	public ArrayList<TGuestDto> getSearchList(String word,int currentPage);
	public int getSearchPostCount(String word);
}
