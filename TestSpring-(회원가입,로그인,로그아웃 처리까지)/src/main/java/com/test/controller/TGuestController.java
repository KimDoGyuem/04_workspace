package com.test.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.dto.RegDto;
import com.test.dto.TGuestDto;
import com.test.service.TGuestService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/guest/*")
@AllArgsConstructor
@Controller
public class TGuestController {

	private TGuestService service;

	@GetMapping("/getList")
	public void getList(@RequestParam(value="word", defaultValue = "null") String word,@RequestParam(value = "currentPage", defaultValue = "1") int currentPage, Model model) {
		if(word==null||word.equals("null")) {
			
			int listCountPerPage = 5;   //페이지당 글 수
			int pagesPerBlock = 3;		//블럭당 페이지 수
			int postCount = service.getPostCount(); //총 글 수
			int totalPageCount = (int)Math.ceil((double)postCount/listCountPerPage); //총 페이지 수
			int currentBlock = (int)Math.ceil((double)currentPage/pagesPerBlock); //현재 블럭
			int blockStartPage = (currentBlock-1)*pagesPerBlock+1;  //블럭 시각 페이지 번호
				model.addAttribute("blockStartPage", blockStartPage);
			int blockEndPage = currentBlock*pagesPerBlock;          //블럭 끝 페이지 번호
			if(blockEndPage>totalPageCount) {
				blockEndPage = totalPageCount;
			}
				model.addAttribute("blockEndPage", blockEndPage);
			int blockCount = (int)Math.ceil((double)totalPageCount/pagesPerBlock); //총 블럭 수
			int prevPage = 0;
			if(currentBlock>1) {
				model.addAttribute("hasPrev",true);
				prevPage = (currentBlock-1)*pagesPerBlock;
				model.addAttribute("prevPage",prevPage);
			}
			int nextPage = 0;
			if(currentBlock<blockCount) {
				model.addAttribute("hasNext",true);
				nextPage = currentBlock*pagesPerBlock+1;
				model.addAttribute("nextPage",nextPage);
			}
			
			model.addAttribute("list", service.getList(currentPage));
			
		}else {
			
			int listCountPerPage = 5;   //페이지당 글 수
			int pagesPerBlock = 3;		//블럭당 페이지 수
			int postCount = service.getSearchPostCount(word); //총 글 수
			int totalPageCount = (int)Math.ceil((double)postCount/listCountPerPage); //총 페이지 수
			int currentBlock = (int)Math.ceil((double)currentPage/pagesPerBlock); //현재 블럭
			int blockStartPage = (currentBlock-1)*pagesPerBlock+1;  //블럭 시각 페이지 번호
				model.addAttribute("blockStartPage", blockStartPage);
			int blockEndPage = currentBlock*pagesPerBlock;          //블럭 끝 페이지 번호
			if(blockEndPage>totalPageCount) {
				blockEndPage = totalPageCount;
			}
				model.addAttribute("blockEndPage", blockEndPage);
			int blockCount = (int)Math.ceil((double)totalPageCount/pagesPerBlock); //총 블럭 수
			int prevPage = 0;
			if(currentBlock>1) {
				model.addAttribute("hasPrev",true);
				prevPage = (currentBlock-1)*pagesPerBlock;
				model.addAttribute("prevPage",prevPage);
			}
			int nextPage = 0;
			if(currentBlock<blockCount) {
				model.addAttribute("hasNext",true);
				nextPage = currentBlock*pagesPerBlock+1;
				model.addAttribute("nextPage",nextPage);
			}
			model.addAttribute("word",word);
			model.addAttribute("list", service.getSearchList(word,currentPage));
			
		}
	}
	
	@GetMapping({ "/read", "modify" })
	public void read(@RequestParam("bno") Long bno, Model model) {
		model.addAttribute("read", service.read(bno));
	}

	@GetMapping("/del")
	public String del(@RequestParam("bno") Long bno) {
		service.del(bno);
		return "redirect:/guest/getList?currentPage=1";
	}

	@PostMapping("/write")
	public String wrtie(TGuestDto dto) {
		service.write(dto);
		return "redirect:/guest/getList?currentPage=1";
	}

	@GetMapping("/write")
	public void write() {

	}

	@PostMapping("/modify")
	public String modify(TGuestDto dto) {
		service.modify(dto);
		return "redirect:/guest/getList?currentPage=1";
	}
	
	@GetMapping("/reg")
	public void reg() { 
		
	}
	
	@PostMapping("/reg")
	public void reg(RegDto d,Model model) {
		model.addAttribute("regCount",service.regCount(d)); 
		service.reg(d);
	}
	
	@GetMapping("/log")
	public void log() {
		
	}
	
	@PostMapping("/log")
	public void log(HttpSession s,@RequestParam("id") String id, @RequestParam("pw") String pw) {
		int logCount = service.logCount(id, pw);
		if(logCount==1) {
			System.out.println("로그인됨");
			s.setAttribute("log", service.log(id, pw));
		}
	}
	
	@GetMapping("/logOut")
	public String logOut(HttpSession s) {
		s.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/test")						
	public void test(HttpServletResponse rs,HttpServletRequest rq) {						
		Cookie c = new Cookie("cat","야옹");					
		rs.addCookie(c);					
							
		Cookie [] cs = rq.getCookies();					
		if (cs != null) {					
			for (Cookie cc : cs) {				
				if ("cat".equals(cc.getName())) {			
					String n = cc.getValue();		
					System.out.println("==== 쿠키 값 찍기: "+n);		
					break;		
				}			
			}				
		}					
	}
	
}


