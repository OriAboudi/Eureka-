package com.spring.stock.spot.data.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
public class StockSpotDto {
    private String name;
    private String symbolName;
    private BigDecimal price;
}
