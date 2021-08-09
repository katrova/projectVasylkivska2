package com.vsemvs.projectVasylkivska.service.implementations;

import com.vsemvs.projectVasylkivska.model.Client;
import com.vsemvs.projectVasylkivska.repository.ClientFakeRepository;
import com.vsemvs.projectVasylkivska.repository.ClientMongoRepository;
import com.vsemvs.projectVasylkivska.service.interfaces.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  ClientServiceImpl
  @version  1.0.0 
  @since 7/30/2021 - 18.03
*/

@AllArgsConstructor
@Service
public class ClientServiceImpl implements IClientService {

    private ClientFakeRepository fakeRepository;
    private ClientMongoRepository mongoRepository;

    //@PostConstruct
    void init(){
        List<Client> list = fakeRepository.getAll();
        mongoRepository.saveAll(list);
    }

    @Override
    public List<Client> getAll() {
        return mongoRepository.findAll();
    }

    @Override
    public Client get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Client create(Client client) {
        client.setCreatedAt(LocalDateTime.now());
        client.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        client.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(client);
    }

    @Override
    public Client delete(String id) {
        Client client = this.get(id);
        mongoRepository.deleteById(id);
        return client;
    }
}
