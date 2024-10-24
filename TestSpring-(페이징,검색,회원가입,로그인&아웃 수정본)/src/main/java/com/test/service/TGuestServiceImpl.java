package com.test.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.test.dto.RegDto;
import com.test.dto.SearchDto;
import com.test.dto.TGuestDto;
import com.test.mapper.TGuestMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class TGuestServiceImpl implements TGuestService{

	private TGuestMapper mapper;
	
	public Model getList(Model m, String word, int currentPage) {
		if(word==null||word.equals("null")) {
			int listCountPerPage = 5;
			int pagesPerBlock = 3;
			int limitIndex = (currentPage-1)*listCountPerPage;
				m.addAttribute("list",mapper.getList(limitIndex));
			int postCount = mapper.getPostCount();
			int totalPageCount = (int)Math.ceil((double)postCount/listCountPerPage);
			int currentBlock = (int)Math.ceil((double)currentPage/pagesPerBlock);
			int blockStartPage = (currentBlock-1)*pagesPerBlock+1;
				m.addAttribute("blockStartPage",blockStartPage);
			int blockEndPage = currentBlock*pagesPerBlock;
			if(blockEndPage>totalPageCount) {
				blockEndPage = totalPageCount;
			}
				m.addAttribute("blockEndPage",blockEndPage);
			int blockCount = (int)Math.ceil((double)totalPageCount/pagesPerBlock);
			int prevPage = 0;
			if(currentBlock>1) {
				m.addAttribute("hasPrev",true);
				prevPage = (currentBlock-1)*pagesPerBlock;
				m.addAttribute("prevPage",prevPage);
			}
			int nextPage = 0;
			if(currentBlock<blockCount) {
				m.addAttribute("hasNext",true);
				nextPage = currentBlock*pagesPerBlock+1;
				m.addAttribute("nextPage",nextPage);
			}
			return m;
		}else {
				m.addAttribute("word",word);
			int listCountPerPage = 5;
			int pagesPerBlock = 3;
			int limitIndex = (currentPage-1)*listCountPerPage;
			SearchDto d = new SearchDto(word,limitIndex);
				m.addAttribute("list",mapper.getSearchList(d));
			int postCount = mapper.getSearchPostCount(word);
			int totalPageCount = (int)Math.ceil((double)postCount/listCountPerPage);
			int currentBlock = (int)Math.ceil((double)currentPage/pagesPerBlock);
			int blockStartPage = (currentBlock-1)*pagesPerBlock+1;
				m.addAttribute("blockStartPage",blockStartPage);
			int blockEndPage = currentBlock*pagesPerBlock;
			if(blockEndPage>totalPageCount) {
				blockEndPage = totalPageCount;
			}
				m.addAttribute("blockEndPage",blockEndPage);
			int blockCount = (int)Math.ceil((double)totalPageCount/pagesPerBlock);
			int prevPage = 0;
			if(currentBlock>1) {
				m.addAttribute("hasPrev",true);
				prevPage = (currentBlock-1)*pagesPerBlock;
				m.addAttribute("prevPage",prevPage);
			}
			int nextPage = 0;
			if(currentBlock<blockCount) {
				m.addAttribute("hasNext",true);
				nextPage = currentBlock*pagesPerBlock+1;
				m.addAttribute("nextPage",nextPage);
			}
			return m;
		}
	}

	
//	public ArrayList<TGuestDto> getList(int currentPage){
//		int limitIndex = (currentPage-1)*5;
//		return mapper.getList(limitIndex);
//	}
//	public int getPostCount() {
//		return mapper.getPostCount();
//	}
//	
//	public ArrayList<TGuestDto> getSearchList(String word,int currentPage){
//		int limitIndex = (currentPage-1)*5;
//		SearchDto d = new SearchDto(word,limitIndex);
//		return mapper.getSearchList(d);
//	}
//	public int getSearchPostCount(String word) {
//		return mapper.getSearchPostCount(word);
//	}
	
	
	
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
	
	public void reg(RegDto d) {
		if(mapper.regCount(d)==0) {
			mapper.reg(d);
		}
	}
	public int regCount(RegDto d) {
		return mapper.regCount(d);
	}
	
	
	public RegDto log(String id,String pw) {
		RegDto r = new RegDto(id,pw);
		return mapper.log(r);
	}
	
	public int logCount(String id, String pw) {
		RegDto r = new RegDto(id,pw);
		return mapper.logCount(r);
	}
}
