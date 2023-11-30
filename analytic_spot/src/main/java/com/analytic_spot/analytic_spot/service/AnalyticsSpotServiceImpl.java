package com.analytic_spot.analytic_spot.service;

import com.analytic_spot.analytic_spot.data.dto.StockSpotDto;
import com.analytic_spot.analytic_spot.data.models.AnalyticsResult;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class AnalyticsSpotServiceImpl implements AnalyticsSpotService {

    @Override
    public AnalyticsResult getAnalytics(List<StockSpotDto> stocksSpot) {
        BigDecimal averagePrice = BigDecimal.ZERO;
        BigDecimal highestPrice = BigDecimal.ZERO;
        BigDecimal lowestPrice = BigDecimal.ZERO;
        BigDecimal totalPrice = BigDecimal.ZERO;
        int totalStocks =0;

        for(StockSpotDto stock: stocksSpot){
            totalStocks++;
            totalPrice.add(stock.getPrice());
            if(highestPrice.compareTo(stock.getPrice())>0){
                highestPrice=stock.getPrice();
            }
            if(lowestPrice.compareTo(stock.getPrice())<0){
                lowestPrice = stock.getPrice();
            }

        }
        averagePrice = totalPrice.divide(BigDecimal.valueOf(totalStocks),2 , RoundingMode.HALF_UP);

        return AnalyticsResult.builder()
                .averagePrice(averagePrice)
                .highestPrice(highestPrice)
                .lowestPrice(lowestPrice)
                .totalPrice(totalPrice)
                .totalStocks(totalStocks)
                .build();
    }
}


