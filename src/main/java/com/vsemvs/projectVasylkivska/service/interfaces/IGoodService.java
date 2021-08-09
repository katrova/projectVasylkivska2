package com.vsemvs.projectVasylkivska.service.interfaces;

import com.vsemvs.projectVasylkivska.model.Good;

import java.util.List;

/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  Order
  @version  1.0.0
  @since 7/30/2021 - 15.12
*/
public interface IGoodService {
    List<Good> getAll();
    Good get(String id);
    Good create(Good good);
    Good update(Good good);
    Good delete(String id);
}
