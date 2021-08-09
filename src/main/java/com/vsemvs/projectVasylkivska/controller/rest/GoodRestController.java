package com.vsemvs.projectVasylkivska.controller.rest;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  GoodRestController
  @version  1.0.0 
  @since 7/19/2021 - 22.19
*/

import com.vsemvs.projectVasylkivska.model.Good;
import com.vsemvs.projectVasylkivska.service.interfaces.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
public class GoodRestController {

    @Autowired
    private IGoodService service;

    @GetMapping("/all")
    public List<Good> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Good get(@PathVariable String id) {
        return service.get(id);
    }

    @GetMapping("/delete/{id}")
    public Good deleteOne(@PathVariable String id) {
        return service.delete(id);
    }

    @PostMapping
    public Good create(@RequestBody Good good) {
        return service.create(good);
    }

}
