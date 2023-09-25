package com.inditex.comercioelectronico.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inditex.comercioelectronico.models.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
	
	@Query("SELECT p FROM Price p WHERE p.brandId = :brandId AND p.productId = :productId AND :applicationDate BETWEEN p.startDate AND p.endDate")
	List<Price> findByBrandIdAndProductIdBetweenStarDateAndEndDate(
			@Param("brandId") Integer brandId,
			@Param("productId") Integer productId,
			@Param("applicationDate") LocalDateTime applicationDate);

}
