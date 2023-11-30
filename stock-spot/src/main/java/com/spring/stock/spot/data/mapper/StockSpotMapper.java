package com.spring.stock.spot.data.mapper;

import com.spring.stock.spot.data.dtos.StockSpotDto;
import com.spring.stock.spot.data.entity.StockSpot;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface StockSpotMapper {
    StockSpot toEntity(StockSpotDto dto);
    StockSpotDto toDto(StockSpot entity);
    List<StockSpot>totoEntities (List<StockSpotDto>stockSpotDtos);
    List<StockSpotDto> toDtos(List<StockSpot>stocksSpot);

}
