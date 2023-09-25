package com.inditex.comercioelectronico.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.inditex.comercioelectronico.exception.PriceNotFoundException;
import com.inditex.comercioelectronico.models.Price;
import com.inditex.comercioelectronico.models.PriceDto;
import com.inditex.comercioelectronico.repository.PriceRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PriceService {

	private final PriceRepository priceRepository;

	private final ModelMapper modelMapper;

	public PriceService(final PriceRepository priceRepository, final ModelMapper modelMapper) {
		super();
		this.priceRepository = priceRepository;
		this.modelMapper = modelMapper;
	}

	public PriceDto findPrice(LocalDateTime applicationDate, Integer productId, Integer brandId)
			throws PriceNotFoundException {
		log.info("Finding price for applicationDate: {}, productId: {},  brandId: {}", applicationDate, productId, brandId);
		List<Price> prices = priceRepository
				.findByBrandIdAndProductIdBetweenStarDateAndEndDate(brandId, productId,
						applicationDate);
		
		if (prices.isEmpty()) {
			log.warn("No prices found for applicationDate: {}, productId: {},  brandId: {}", applicationDate, productId, brandId);
			throw new PriceNotFoundException("No price found");
		}

		Price selectedPrice = prices.stream().max(Comparator.comparingInt(Price::getPriority))
				.orElseThrow(() ->{
					log.error("Unexpected error while selecting price");
					return new PriceNotFoundException("No price found");
					});

		return modelMapper.map(selectedPrice, PriceDto.class);
	}

}
