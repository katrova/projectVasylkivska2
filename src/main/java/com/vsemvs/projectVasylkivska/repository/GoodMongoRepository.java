package com.vsemvs.projectVasylkivska.repository;

import com.vsemvs.projectVasylkivska.model.Good;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  GoodMongoRepository
  @version  1.0.0 
  @since 7/30/2021 - 15.31
*/
public interface GoodMongoRepository extends MongoRepository<Good, String> {
    List<Good> findByName(String name);
}