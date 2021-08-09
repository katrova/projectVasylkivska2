package com.vsemvs.projectVasylkivska.controller.gui;

/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  ClientGuiController
  @version  1.0.0 
  @since 7/30/2021 - 18.16
*/

import com.vsemvs.projectVasylkivska.forms.ClientForm;
import com.vsemvs.projectVasylkivska.model.Client;
import com.vsemvs.projectVasylkivska.service.interfaces.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/gui/clients")
@AllArgsConstructor
public class ClientGuiController {

    private IClientService service;

    @RequestMapping("/all")
    public String getAll(Model model) {

        List<Client> clients = service.getAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(ModelMap model, @PathVariable String id) {
        service.delete(id);
        return new ModelAndView("redirect:/gui/clients/all", model);
    }

    @RequestMapping("/create")
    public String create(ModelMap model) {
        ClientForm formToCreate = new ClientForm();
        model.addAttribute("form", formToCreate);
        return "client-create";
    }

    @PostMapping("/create")
    public ModelAndView create(ModelMap model, @ModelAttribute("form") ClientForm form) {
        Client client = new Client(form.getName(), form.getDescription(), form.getAddress(),
                form.getPhoneNumber(), form.getContactPerson());
        service.create(client);
        return new ModelAndView("redirect:/gui/clients/all", model);
    }

    @RequestMapping("/update/{id}")
    public String update(ModelMap model, @PathVariable String id) {
        Client client = service.get(id);
        ClientForm formToUpdate = new ClientForm(client.getName(), client.getDescription(),
                client.getAddress(), client.getPhoneNumber(), client.getContactPerson());
        model.addAttribute("form", formToUpdate);
        return "client-update";
    }

    @PostMapping("/update/{id}")
    public ModelAndView update(ModelMap model, @ModelAttribute("form") ClientForm form, @PathVariable String id) {
        Client client = service.get(id);
        client.setName(form.getName());
        client.setDescription(form.getDescription());
        client.setAddress(form.getAddress());
        client.setPhoneNumber(form.getPhoneNumber());
        client.setContactPerson(form.getContactPerson());
        service.update(client);
        return new ModelAndView("redirect:/gui/clients/all", model);
    }
}
