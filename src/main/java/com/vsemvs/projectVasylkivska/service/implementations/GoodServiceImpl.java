package com.vsemvs.projectVasylkivska.service.implementations;

import com.vsemvs.projectVasylkivska.model.Good;
import com.vsemvs.projectVasylkivska.repository.FakeGoodRepository;
import com.vsemvs.projectVasylkivska.repository.GoodMongoRepository;
import com.vsemvs.projectVasylkivska.service.interfaces.IGoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  Order
  @version  1.0.0
  @since 7/30/2021 - 15.12
*/

@AllArgsConstructor
@Service
public class GoodServiceImpl implements IGoodService {

    private FakeGoodRepository fakeGoodRepository;
    private GoodMongoRepository mongoRepository;

    //@PostConstruct
    void init(){
        List<Good> list = fakeGoodRepository.getAll();
        mongoRepository.saveAll(list);
    }

    @Override
    public List<Good> getAll() {
        return mongoRepository.findAll();
    }

    @Override
    public Good get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Good create(Good good) {
        good.setCreatedAt(LocalDateTime.now());
        good.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(good);
    }

    @Override
    public Good update(Good good) {
        good.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(good);
    }

    @Override
    public Good delete(String id) {
        Good good = this.get(id);
        mongoRepository.deleteById(id);
        return good;
    }
}
