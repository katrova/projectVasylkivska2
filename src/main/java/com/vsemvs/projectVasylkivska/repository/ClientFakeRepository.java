package com.vsemvs.projectVasylkivska.repository;

import com.vsemvs.projectVasylkivska.model.Client;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  Order
  @version  1.0.0
  @since 7/30/2021 - 15.12
*/
@Repository
public class ClientFakeRepository {

    private LocalDateTime time = LocalDateTime.now();
    private List<Client> clients = new ArrayList<>(
            Arrays.asList(
                    new Client("0", "Client 0", "Desc 0", time, time, "Adress 0", "+380980980908", "Person 0"),
                    new Client("1", "Client 1", "Desc 1", time, time, "Adress 1", "+380980980907", "Person 1"),
                    new Client("2", "Client 2", "Desc 2", time, time, "Adress 2", "+380980980906", "Person 2")
            )
    );

    public List<Client> getAll() {
        return clients;
    }

    public Client get(String id) {
        return clients.stream()
                .filter(el -> el.getId().equals(id))
                .findFirst()
                .get();
    }

    public Client create(Client client) {
        UUID uuid = UUID.randomUUID();
        client.setId(uuid.toString());
        client.setCreatedAt(LocalDateTime.now());
        client.setUpdatedAt(LocalDateTime.now());
        clients.add(client);
        return client;
    }

    public Client update(Client client) {
        Client founded = this.get(client.getId());
        int index = clients.indexOf(founded);
        clients.remove(founded);
        client.setCreatedAt(founded.getCreatedAt());
        client.setUpdatedAt(LocalDateTime.now());
        clients.add(index, client);
        return client;
    }

    public Client delete(String id) {
        Client client =  this.get(id);
        clients.remove(client);
        return client;
    }
    
}
