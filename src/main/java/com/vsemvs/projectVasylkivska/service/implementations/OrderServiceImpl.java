package com.vsemvs.projectVasylkivska.service.implementations;

import com.vsemvs.projectVasylkivska.model.Order;
import com.vsemvs.projectVasylkivska.repository.OrderMongoRepository;
import com.vsemvs.projectVasylkivska.service.interfaces.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  Order
  @version  1.0.0
  @since 7/30/2021 - 15.12
*/

@AllArgsConstructor
@Service
public class OrderServiceImpl implements IOrderService {

    private OrderMongoRepository mongoRepository;

    @Override
    public List<Order> getAll() {
        return mongoRepository.findAll();
    }

    @Override
    public Order get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Order create(Order order) {
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        order.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(order);
    }

    @Override
    public Order delete(String id) {
        Order order = this.get(id);
        mongoRepository.deleteById(id);
        return order;
    }
}
