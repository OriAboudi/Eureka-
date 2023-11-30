package com.analytic_spot.analytic_spot.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class StockSpotDto {
    private String name;
    private String symbolName;
    private BigDecimal price;
}
