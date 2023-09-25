package com.inditex.comercioelectronico.models;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PriceDto {
	
	private Integer productId;
	private Integer brandId;
	private Integer priceList;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Double price;
}
