package com.spring.stock.spot.data.repository;

import com.spring.stock.spot.data.entity.StockSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StockSpotRepository extends JpaRepository<StockSpot, UUID> {
}
