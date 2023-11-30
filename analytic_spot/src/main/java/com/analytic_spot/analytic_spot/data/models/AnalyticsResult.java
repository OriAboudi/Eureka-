package com.analytic_spot.analytic_spot.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class AnalyticsResult {


    private BigDecimal averagePrice;
    private LocalDate firstCreationTimestamp;
    private LocalDate lastUpdatedTimestamp;
    private BigDecimal totalPrice;
    private int totalStocks;
    private BigDecimal highestPrice;
    private BigDecimal lowestPrice;
}
