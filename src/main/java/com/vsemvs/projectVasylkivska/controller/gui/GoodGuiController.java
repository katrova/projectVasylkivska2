package com.vsemvs.projectVasylkivska.controller.gui;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  GoodGuiController
  @version  1.0.0 
  @since 7/30/2021 - 18.16
*/

import com.vsemvs.projectVasylkivska.forms.GoodForm;
import com.vsemvs.projectVasylkivska.forms.GoodReadForm;
import com.vsemvs.projectVasylkivska.model.Good;
import com.vsemvs.projectVasylkivska.service.interfaces.IGoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/gui/goods")
@AllArgsConstructor
public class GoodGuiController {

    private IGoodService service;

    @RequestMapping("/all")
    public String getAll(Model model) {
        List<GoodReadForm> goodForms = service.getAll().stream()
                .map(GoodReadForm::new)
                .collect(Collectors.toList());
        model.addAttribute("goods", goodForms);
        return "goods";
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(ModelMap model, @PathVariable String id) {
        service.delete(id);
        return new ModelAndView("redirect:/gui/goods/all", model);
    }

    @RequestMapping("/create")
    public String create(ModelMap model) {
        GoodForm formToCreate = new GoodForm();
        model.addAttribute("form", formToCreate);
        return "good-create";
    }

    @PostMapping("/create")
    public ModelAndView create(ModelMap model, @ModelAttribute("form") GoodForm form) {
        Good good = new Good(form.getName(), form.getDescription(), form.getSingleGoodPrice(),
                form.getMultipleGoodPrice());
        service.create(good);
        return new ModelAndView("redirect:/gui/goods/all", model);
    }

    @RequestMapping("/update/{id}")
    public String update(ModelMap model, @PathVariable String id) {
        Good good = service.get(id);
        GoodForm formToUpdate = new GoodForm(good.getName(), good.getDescription(),
                good.getSingleGoodPrice(), good.getMultipleGoodPrice()
        );
        model.addAttribute("form", formToUpdate);
        return "good-update";
    }

    @PostMapping("/update/{id}")
    public ModelAndView update(ModelMap model, @ModelAttribute("form") GoodForm form, @PathVariable String id) {
        Good good = service.get(id);
        good.setName(form.getName());
        good.setDescription(form.getDescription());
        good.setSingleGoodPrice(form.getSingleGoodPrice());
        good.setMultipleGoodPrice(form.getMultipleGoodPrice());
        service.update(good);
        return new ModelAndView("redirect:/gui/goods/all", model);
    }
}
