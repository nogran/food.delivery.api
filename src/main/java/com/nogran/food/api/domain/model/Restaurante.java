package com.nogran.food.api.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Restaurante {

    @Id
    private Long id;

    private String name;

    @Column(name = "delivery_tax")
    private BigDecimal deliveryTax;
}
