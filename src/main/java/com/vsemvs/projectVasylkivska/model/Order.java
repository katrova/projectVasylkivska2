package com.vsemvs.projectVasylkivska.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  Order
  @version  1.0.0 
  @since 7/30/2021 - 15.12
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Order {

    @Id
    private String id;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Client client;

    private List<Pair<Good, Integer>> goodToAmountMap;
    private LocalDate purchaseDate;
    private boolean isWholeSale;
    private double discount;

    public Order(Client client, List<Pair<Good, Integer>> goodToAmountMap, LocalDate purchaseDate, boolean isWholeSale, double discount, String description) {
        this.client = client;
        this.goodToAmountMap = goodToAmountMap;
        this.purchaseDate = purchaseDate;
        this.isWholeSale = isWholeSale;
        this.discount = discount;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getId().equals(order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
