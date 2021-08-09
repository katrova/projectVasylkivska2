package com.vsemvs.projectVasylkivska.repository;

import com.vsemvs.projectVasylkivska.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  OrderMongoRepository
  @version  1.0.0 
  @since 7/30/2021 - 15.33
*/
public interface OrderMongoRepository extends MongoRepository<Order, String> {
}

