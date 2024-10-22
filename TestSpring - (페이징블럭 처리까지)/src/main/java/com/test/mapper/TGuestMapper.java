package com.test.mapper;

import java.util.ArrayList;

import com.test.dto.TGuestDto;

public interface TGuestMapper {
	public ArrayList<TGuestDto> getList(int limitIndex);
	public TGuestDto read(long bno);
	public void del(long bno);
	public void write(TGuestDto dto);
	public void modify(TGuestDto dto);
	
	public int getPostCount();
}
