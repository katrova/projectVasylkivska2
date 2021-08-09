package com.vsemvs.projectVasylkivska.service.interfaces;

import com.vsemvs.projectVasylkivska.model.Client;

import java.util.List;

/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  Order
  @version  1.0.0
  @since 7/30/2021 - 15.12
*/
public interface IClientService {
    List<Client> getAll();
    Client get(String id);
    Client create(Client client);
    Client update(Client client);
    Client delete(String id);
}
