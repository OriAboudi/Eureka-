package com.spring.stock.spot.data.repository;

import com.spring.stock.spot.data.entity.StockSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockSpotRepository extends JpaRepository<StockSpot, Long> {
}
