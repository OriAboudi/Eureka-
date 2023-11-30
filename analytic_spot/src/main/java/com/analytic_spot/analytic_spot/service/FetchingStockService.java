package com.analytic_spot.analytic_spot.service;

import com.analytic_spot.analytic_spot.data.dto.StockSpotDto;

import java.util.List;

public interface fetchingStockService {
    List<StockSpotDto> getAllStocks();
}
