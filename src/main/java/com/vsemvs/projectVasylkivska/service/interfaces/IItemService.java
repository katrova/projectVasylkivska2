package com.vsemvs.projectVasylkivska.service.interfaces;

import com.vsemvs.projectVasylkivska.model.Item;

import java.util.List;

/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  Order
  @version  1.0.0
  @since 7/30/2021 - 15.12
*/
public interface IItemService {
    List<Item> getAll();
    Item get(String id);
    Item create(Item item);
    Item update(Item item);
    Item delete(String id);
}
