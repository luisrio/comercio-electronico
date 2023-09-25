package com.inditex.comercioelectronico.controller;

import java.time.LocalDateTime;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.inditex.comercioelectronico.exception.PriceNotFoundException;
import com.inditex.comercioelectronico.models.PriceDto;
import com.inditex.comercioelectronico.service.PriceService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PriceController {

	private PriceService priceService;

	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}

	@GetMapping("/price")
	public ResponseEntity<PriceDto> getPrice(
			@RequestParam("applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @NotNull LocalDateTime applicationDate,
			@RequestParam("productId")@NotNull @Min(1) Integer productId, 
			@RequestParam("brandId")@NotNull @Min(1) Integer brandId)
			throws PriceNotFoundException {

		PriceDto price = priceService.findPrice(applicationDate, productId, brandId);
		log.info("Returning price: {}", price);
		return new ResponseEntity<>(price, HttpStatus.OK);
	}

}
