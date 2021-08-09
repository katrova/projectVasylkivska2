package com.vsemvs.projectVasylkivska.service.interfaces;

import com.vsemvs.projectVasylkivska.model.Client;

import java.util.List;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  IClientService
  @version  1.0.0 
  @since 7/30/2021 - 18.01
*/
public interface IClientService {
    List<Client> getAll();
    Client get(String id);
    Client create(Client client);
    Client update(Client client);
    Client delete(String id);
}
