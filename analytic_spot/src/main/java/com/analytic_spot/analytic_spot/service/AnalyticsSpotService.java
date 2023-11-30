package com.analytic_spot.analytic_spot.service;

import com.analytic_spot.analytic_spot.data.dto.StockSpotDto;
import com.analytic_spot.analytic_spot.data.models.AnalyticsResult;

import java.util.List;

public interface AnalyticsSpotService {
    AnalyticsResult getAnalytics(List<StockSpotDto> stocksSpot);

}
