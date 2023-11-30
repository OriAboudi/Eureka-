package com.analytic_spot.analytic_spot.service;

import com.analytic_spot.analytic_spot.data.dto.StockSpotDto;
import com.analytic_spot.analytic_spot.data.models.AnalyticsResult;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


@Service
public class AnalyticsSpotServiceImpl implements AnalyticsSpotService {

    @Override
    public AnalyticsResult getAnalytics(List<StockSpotDto> stocksSpot) {

        BigDecimal highestPrice = stocksSpot.get(0).getPrice();
        BigDecimal lowestPrice = stocksSpot.get(0).getPrice();
        BigDecimal totalPrice = BigDecimal.ZERO;


        for (StockSpotDto stock : stocksSpot) {
            BigDecimal price = stock.getPrice();

            totalPrice = totalPrice.add(price);

            if (price.compareTo(highestPrice) > 0) {
                highestPrice = price;
            }
            if (price.compareTo(lowestPrice) < 0) {
                lowestPrice = price;
            }
        }
        int totalStocks = stocksSpot.size();

        BigDecimal averagePrice = totalPrice.divide(BigDecimal.valueOf(totalStocks), 2, RoundingMode.HALF_UP);

        return AnalyticsResult.builder()
                .averagePrice(averagePrice)
                .highestPrice(highestPrice)
                .lowestPrice(lowestPrice)
                .totalPrice(totalPrice)
                .totalStocks(totalStocks)
                .build();
    }
}


