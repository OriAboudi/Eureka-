package com.spring.stock.spot.service;

import com.spring.stock.spot.data.dtos.StockSpotDto;
import com.spring.stock.spot.data.entity.StockSpot;
import com.spring.stock.spot.data.mapper.StockSpotMapper;
import com.spring.stock.spot.data.repository.StockSpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockSpotServiceImpl implements StockSpotService {

    private final StockSpotMapper mapper;
    private final StockSpotRepository repository;

    @Override
    public List<StockSpotDto> findAll() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public StockSpotDto insert(StockSpotDto stockSpotDto ) {
        return mapper.toDto(mapper.toEntity(stockSpotDto));
    }
}
