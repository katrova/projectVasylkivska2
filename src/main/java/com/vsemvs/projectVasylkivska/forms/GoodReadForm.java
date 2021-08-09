package com.vsemvs.projectVasylkivska.forms;

import com.vsemvs.projectVasylkivska.model.Good;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  GoodReadForm
  @version  1.0.0 
  @since 7/30/2021 - 19.37
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodReadForm {
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private BigDecimal singleGoodPrice;
    private BigDecimal multipleGoodPrice;

    public GoodReadForm(Good good) {
        this.id = good.getId();
        this.createdAt = good.getCreatedAt();
        this.updatedAt = good.getUpdatedAt();
        this.name = good.getName();
        this.description = good.getDescription();
        this.singleGoodPrice = good.getSingleGoodPrice();
        this.multipleGoodPrice = good.getMultipleGoodPrice();
    }
}
