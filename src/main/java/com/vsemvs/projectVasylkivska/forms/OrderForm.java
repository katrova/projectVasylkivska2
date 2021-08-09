package com.vsemvs.projectVasylkivska.forms;

import com.vsemvs.projectVasylkivska.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  OrderForm
  @version  1.0.0 
  @since 7/31/2021 - 14.49
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {
    private String description;
    private String client;
    private String goodsAndAmounts;
    private String purchaseDate;
    private boolean isWholeSale;
    private double discount;

    public OrderForm(Order order) {
        this.description = order.getDescription();
        this.client = order.getClient().getName();
        this.goodsAndAmounts = order.getGoodToAmountMap().stream()
                .map(entry -> entry.getKey().getName() + "-" + entry.getValue())
                .collect(Collectors.joining(",\n"));
        this.isWholeSale = order.isWholeSale();
        this.discount = order.getDiscount();
        this.purchaseDate = order.getPurchaseDate().toString();
    }

    public boolean getIsWholeSale() {
        return isWholeSale;
    }

    public void setIsWholeSale(boolean wholeSale) {
        isWholeSale = wholeSale;
    }
}
