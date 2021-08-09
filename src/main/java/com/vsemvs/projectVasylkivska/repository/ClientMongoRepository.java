package com.vsemvs.projectVasylkivska.repository;

import com.vsemvs.projectVasylkivska.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  ClientMongoRepository
  @version  1.0.0 
  @since 7/30/2021 - 15.30
*/
public interface ClientMongoRepository extends MongoRepository<Client, String> {
    List<Client> findByName(String name);
}

