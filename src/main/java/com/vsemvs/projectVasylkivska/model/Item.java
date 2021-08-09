package com.vsemvs.projectVasylkivska.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  Item
  @version  1.0.0 
  @since 7/16/2021 - 12.10
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Item {

    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId().equals(item.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
