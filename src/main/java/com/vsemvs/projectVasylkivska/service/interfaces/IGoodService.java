package com.vsemvs.projectVasylkivska.service.interfaces;

import com.vsemvs.projectVasylkivska.model.Good;

import java.util.List;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  IGoodService
  @version  1.0.0 
  @since 7/19/2021 - 19.01
*/
public interface IGoodService {
    List<Good> getAll();
    Good get(String id);
    Good create(Good good);
    Good update(Good good);
    Good delete(String id);
}
