package com.analytic_spot.analytic_spot.service;

import com.analytic_spot.analytic_spot.data.dto.StockSpotDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class fetchingStockServiceImpl implements FetchingStockService {
    private final RestTemplate restTemplate;
    private final String stockSpotURL;

    public fetchingStockServiceImpl(
            RestTemplate restTemplate,
            @Value("${stock.spot.url}") String stockSpotURL) {
        this.restTemplate = restTemplate;
        this.stockSpotURL = stockSpotURL;
    }
    @Override
    public List<StockSpotDto> getAllStocks() {
        ResponseEntity<StockSpotDto[]> responseEntity = restTemplate.getForEntity(stockSpotURL, StockSpotDto[].class);
        if(responseEntity.getStatusCode().is2xxSuccessful()&& responseEntity.getBody()!=null){
            return Arrays.stream(responseEntity.getBody()).toList();
        }
        return Collections.emptyList();
    }
}
