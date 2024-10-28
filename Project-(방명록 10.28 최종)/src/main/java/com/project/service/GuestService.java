package com.project.service;

import com.project.dto.AccountDto;
import com.project.dto.GuestDto;
import com.project.listproc.ListProc;

public interface GuestService {
	
	//페이징 블럭 처리 blp처럼 나누기 , listproc 패키지 추가함
	public ListProc getList(String word, int currentPage);
	
	public GuestDto read(long bno);
	public void del(long bno);
	public void write(GuestDto g);
	public void modify(GuestDto g);
	
	public void reg(AccountDto a);
	public int regCount(AccountDto a);
	
//	public AccountDto log(String id,String pw);
//	public int logCount(String id,String pw);
	public AccountDto log(AccountDto a);
	public int logCount(AccountDto a);
}
