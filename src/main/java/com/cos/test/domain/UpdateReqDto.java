package com.cos.test.domain;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data

public class UpdateReqDto {
	
	@NotNull
	private String title;
	
	@NotNull
	private double rating;
}
