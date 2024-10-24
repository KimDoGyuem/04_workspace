package com.test.dto;

import lombok.Data;

@Data
public class RegDto {
	private String id;
	private String pw;
	
	public RegDto(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
}
