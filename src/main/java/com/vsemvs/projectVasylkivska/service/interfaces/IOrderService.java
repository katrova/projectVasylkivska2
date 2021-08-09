package com.vsemvs.projectVasylkivska.service.interfaces;

import com.vsemvs.projectVasylkivska.model.Order;

import java.util.List;

/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  Order
  @version  1.0.0
  @since 7/30/2021 - 15.12
*/
public interface IOrderService {
    List<Order> getAll();
    Order get(String id);
    Order create(Order order);
    Order update(Order order);
    Order delete(String id);
}
