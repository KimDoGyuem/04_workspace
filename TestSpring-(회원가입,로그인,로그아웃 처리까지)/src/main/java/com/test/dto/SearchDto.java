package com.test.dto;

import lombok.Data;

@Data
public class SearchDto {
	private String word;
	private int limitIndex;
	
	public SearchDto(String word, int limitIndex) {
		super();
		this.word = word;
		this.limitIndex = limitIndex;
	}
	
}
