package com.vsemvs.projectVasylkivska.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  Client
  @version  1.0.0 
  @since 7/30/2021 - 15.03
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Client {

    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String address;
    private String phoneNumber;
    private String contactPerson;

    public Client(String name, String description, String address, String phoneNumber, String contactPerson) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.contactPerson = contactPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return getId().equals(client.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
