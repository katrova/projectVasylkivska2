package com.vsemvs.projectVasylkivska.service.implementations;

import com.vsemvs.projectVasylkivska.model.Item;
import com.vsemvs.projectVasylkivska.repository.ItemMongoRepository;
import com.vsemvs.projectVasylkivska.service.interfaces.IItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  ItemServiceImpl
  @version  1.0.0 
  @since 7/18/2021 - 19.27
*/

@AllArgsConstructor
@Service
public class ItemServiceImpl implements IItemService {

    ItemMongoRepository mongoRepository;

    //@PostConstruct
    void init(){
        //List<Item> list = repository.getAll();
        //mongoRepository.saveAll(list);
    }

    @Override
    public List<Item> getAll() {
        return mongoRepository.findAll();
    }

    @Override
    public Item get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Item create(Item item) {
        item.setCreatedAt(LocalDateTime.now());
        item.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(item);
    }

    @Override
    public Item update(Item item) {
        item.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(item);
    }

    @Override
    public Item delete(String id) {
        Item item = this.get(id);
        mongoRepository.deleteById(id);
        return item;
    }
}
