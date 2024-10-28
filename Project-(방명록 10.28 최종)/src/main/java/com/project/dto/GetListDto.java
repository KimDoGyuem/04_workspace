package com.project.dto;

import lombok.Data;

@Data
public class GetListDto {
	private String word;
	private int offset = 0;			//limit index 시작 
	private int rowCount = 5;	//끝 
	
	public GetListDto(int offset) {
		super();
		this.offset = offset;
	}
	
	public GetListDto(String word, int offset) {
		super();
		this.word = word;
		this.offset = offset;
	}
	
}
