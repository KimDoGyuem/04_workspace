package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.service.T_TestService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/test/*")
@Controller
public class T_TestController {
	
	@Setter(onMethod_ = @Autowired)
	private T_TestService service;
	
	@GetMapping("/getOnePlusTwo")
	public void getOnePlusTwo(Model model) {
		log.info("getOnePlusTwo=========");
		String one = service.getOne();
		String two = service.getTwo();
		String three = service.getThree();
		String four = service.getFour();
		Integer sum = Integer.parseInt(one)+Integer.parseInt(two)+Integer.parseInt(three);
		log.info("(컨트롤러임)1+2+100은===:"+sum);
		log.info("4는=:"+four);
		model.addAttribute("sum",sum);
		model.addAttribute("four",four);
	}
	
	@GetMapping("/updateTest")
	public void updateTest() {
		log.info("===컨트롤러 업데이트 실행");
		service.update();
		log.info("===컨트롤러 업데이트 실행 완료됨");
	}
	
	@GetMapping("/insertTest")
	public void insertTest() {
		log.info("===컨트롤러 인서트 실행");
		service.insert();
		log.info("===컨트롤러 인서트 실행 완료됨");
	}
	
	@GetMapping("/delTest")
	public void delTest(){
		log.info("===컨트롤러 딜레이트 실행");
		service.del();
		log.info("===컨트롤러 딜레이트 실행 완료됨");
	}
	
}
