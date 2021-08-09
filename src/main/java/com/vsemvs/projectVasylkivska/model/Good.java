package com.vsemvs.projectVasylkivska.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  Good
  @version  1.0.0 
  @since 7/19/2021 - 19.15
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Good {

    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private BigDecimal singleGoodPrice;
    private BigDecimal multipleGoodPrice;

    public Good(String name, String description, BigDecimal singleGoodPrice, BigDecimal multipleGoodPrice) {
        this.name = name;
        this.description = description;
        this.singleGoodPrice = singleGoodPrice;
        this.multipleGoodPrice = multipleGoodPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return getId().equals(good.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
