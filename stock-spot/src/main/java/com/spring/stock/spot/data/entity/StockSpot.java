package com.spring.stock.spot.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.descriptor.jdbc.CharJdbcType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StockSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcType(CharJdbcType.class)
    UUID id;
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
