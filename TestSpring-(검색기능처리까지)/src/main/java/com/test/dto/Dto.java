package com.test.dto;

import lombok.Data;

@Data
public class Dto {
	private String word;
	private int limitIndex;
	
	public Dto(String word, int limitIndex) {
		super();
		this.word = word;
		this.limitIndex = limitIndex;
	}
	
}
