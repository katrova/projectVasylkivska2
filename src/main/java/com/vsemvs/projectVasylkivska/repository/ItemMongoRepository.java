package com.vsemvs.projectVasylkivska.repository;

import com.vsemvs.projectVasylkivska.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  Order
  @version  1.0.0
  @since 7/30/2021 - 15.12
*/
public interface ItemMongoRepository extends MongoRepository<Item, String> {
}
