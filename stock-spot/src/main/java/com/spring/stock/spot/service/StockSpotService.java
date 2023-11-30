package com.spring.stock.spot.service;

import com.spring.stock.spot.data.dtos.StockSpotDto;
import com.spring.stock.spot.data.entity.StockSpot;

import java.util.List;

public interface StockSpotService {
    List<StockSpotDto> findAll();
    StockSpotDto insert(StockSpotDto stockSpotDto );

}
