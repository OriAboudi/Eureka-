package com.spring.stock.spot.service;

import com.spring.stock.spot.data.dtos.StockSpotDto;
import com.spring.stock.spot.data.entity.StockSpot;
import com.spring.stock.spot.data.mapper.StockSpotMapper;
import com.spring.stock.spot.data.repository.StockSpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockSpotServiceImpl implements StockSpotService {

    private final StockSpotMapper mapper;
    private final StockSpotRepository repository;

    public static void changeStockPriceRandomly(StockSpot stock) {
        int sign = Math.random() > 0.5 ? 1 : -1;
        BigDecimal priceChanged = BigDecimal.valueOf(sign * Math.random() * 10)
                .setScale(2, RoundingMode.HALF_UP);
        stock.setPrice(priceChanged);
    }

    @Override
    public List<StockSpotDto> findAll() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public StockSpotDto insert(StockSpotDto stockSpotDto) {
        return mapper.toDto(repository.save(mapper.toEntity(stockSpotDto)));
    }

    // update the price of stocks all 15 minutes
    @Override
    @Scheduled(cron = "0 */15 * * * *")
    public void updateStockPrice() {

        List<StockSpot> stockSpots = repository.findAll();
        stockSpots.forEach(StockSpotServiceImpl::changeStockPriceRandomly);
        repository.saveAll(stockSpots);
    }
}
