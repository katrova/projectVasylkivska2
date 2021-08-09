package com.vsemvs.projectVasylkivska.forms;

import com.vsemvs.projectVasylkivska.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  OrderReadForm
  @version  1.0.0 
  @since 7/31/2021 - 19.43
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderReadForm {
    private String id;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String client;
    private String goodsAndAmounts;
    private String purchaseDate;
    private boolean isWholeSale;
    private double discount;

    public OrderReadForm(Order order) {
        this.id = order.getId();
        this.description = order.getDescription();
        this.createdAt = order.getCreatedAt();
        this.updatedAt = order.getUpdatedAt();
        this.client = order.getClient().getName();
        this.goodsAndAmounts = order.getGoodToAmountMap().stream()
                .map(entry -> entry.getKey().getName() + "-" + entry.getValue())
                .collect(Collectors.joining(",\n"));
        this.isWholeSale = order.isWholeSale();
        this.discount = order.getDiscount();
        this.purchaseDate = order.getPurchaseDate().toString();
    }

}
