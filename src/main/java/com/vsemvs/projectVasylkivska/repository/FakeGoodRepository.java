package com.vsemvs.projectVasylkivska.repository;

import com.vsemvs.projectVasylkivska.model.Good;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  GoodFakeRepository
  @version  1.0.0 
  @since 7/30/2021 - 15.36
*/
@Repository
public class FakeGoodRepository {

    private LocalDateTime time = LocalDateTime.now();
    private List<Good> goods = new ArrayList<>(
            Arrays.asList(
                    new Good("0", "Good 0", "Desc 0", time, time, new BigDecimal(20), new BigDecimal(15)),
                    new Good("1", "Good 1", "Desc 1", time, time, new BigDecimal(15), new BigDecimal(10)),
                    new Good("2", "Good 2", "Desc 2", time, time, new BigDecimal(25), new BigDecimal(20))
            )
    );

    public List<Good> getAll() {
        return goods;
    }

    public Good get(String id) {
        return goods.stream()
                .filter(el -> el.getId().equals(id))
                .findFirst()
                .get();
    }

    public Good create(Good good) {
        UUID uuid = UUID.randomUUID();
        good.setId(uuid.toString());
        good.setCreatedAt(LocalDateTime.now());
        good.setUpdatedAt(LocalDateTime.now());
        goods.add(good);
        return good;
    }

    public Good update(Good good) {
        Good founded = this.get(good.getId());
        int index = goods.indexOf(founded);
        goods.remove(founded);
        good.setCreatedAt(founded.getCreatedAt());
        good.setUpdatedAt(LocalDateTime.now());
        goods.add(index, good);
        return good;
    }

    public Good delete(String id) {
        Good good =  this.get(id);
        goods.remove(good);
        return good;
    }

}
