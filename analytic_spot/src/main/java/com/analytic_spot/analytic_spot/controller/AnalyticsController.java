package com.analytic_spot.analytic_spot.controller;

import com.analytic_spot.analytic_spot.data.dto.StockSpotDto;
import com.analytic_spot.analytic_spot.data.models.AnalyticsResult;
import com.analytic_spot.analytic_spot.service.AnalyticsSpotService;
import com.analytic_spot.analytic_spot.service.FetchingStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/analytics_spot")
public class AnalyticsController {
    private final AnalyticsSpotService analyticsSpotService;
    private final FetchingStockService fetchingStockService;
    @GetMapping
    ResponseEntity<AnalyticsResult>getAnalytics(){
        List<StockSpotDto> allStocks = fetchingStockService.getAllStocks();
        return ResponseEntity
                .ok(analyticsSpotService.getAnalytics(allStocks));
    }
}
