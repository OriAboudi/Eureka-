package com.spring.stock.spot.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StockSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    Long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false, updatable = false)
    String symbolName;
    BigDecimal price;
    @CreationTimestamp
    @Column(updatable = false)
    LocalDate creationTimestamp;
    @UpdateTimestamp
    LocalDate updatedTimestamp;
    @Version
    Long version;
}
