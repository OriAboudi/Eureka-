package com.spring.stock.spot.controller;

import com.spring.stock.spot.data.dtos.StockSpotDto;
import com.spring.stock.spot.service.StockSpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/stock_spot")
public class StockSpotController {
    private final StockSpotService service;

    @GetMapping
    ResponseEntity<List<StockSpotDto>> finalAll() {
        return ResponseEntity.ok(
                service.findAll());
    }

    @PostMapping("/add")
    ResponseEntity<StockSpotDto> insert(
            @RequestBody StockSpotDto stockSpotDto
    ){
        return ResponseEntity.ok(service.insert(stockSpotDto));
    }

}
