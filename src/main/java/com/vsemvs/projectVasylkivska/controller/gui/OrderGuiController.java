package com.vsemvs.projectVasylkivska.controller.gui;

/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  OrderGuiController
  @version  1.0.0 
  @since 7/30/2021 - 18.17
*/

import com.vsemvs.projectVasylkivska.forms.OrderForm;
import com.vsemvs.projectVasylkivska.forms.OrderReadForm;
import com.vsemvs.projectVasylkivska.model.Client;
import com.vsemvs.projectVasylkivska.model.Good;
import com.vsemvs.projectVasylkivska.model.Order;
import com.vsemvs.projectVasylkivska.model.Pair;
import com.vsemvs.projectVasylkivska.repository.ClientMongoRepository;
import com.vsemvs.projectVasylkivska.repository.GoodMongoRepository;
import com.vsemvs.projectVasylkivska.service.interfaces.IClientService;
import com.vsemvs.projectVasylkivska.service.interfaces.IGoodService;
import com.vsemvs.projectVasylkivska.service.interfaces.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/gui/orders")
@AllArgsConstructor
public class OrderGuiController {

    private IOrderService orderService;
    private IClientService clientService;
    private ClientMongoRepository clientMongoRepository;
    private IGoodService goodService;
    private GoodMongoRepository goodMongoRepository;

    @RequestMapping("/all")
    public String getAll(Model model) {
        List<OrderReadForm> orderForms = orderService.getAll().stream()
                .map(OrderReadForm::new)
                .collect(Collectors.toList());
        model.addAttribute("orders", orderForms);
        return "orders";
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(ModelMap model, @PathVariable String id) {
        orderService.delete(id);
        return new ModelAndView("redirect:/gui/orders/all", model);
    }

    @RequestMapping("/create")
    public String create(ModelMap model) {
        OrderForm formToCreate = new OrderForm();
        model.addAttribute("form", formToCreate);
        return "order-create";
    }

    @PostMapping("/create")
    public ModelAndView create2(ModelMap model, @ModelAttribute("form") OrderForm form) {
        Client client = clientMongoRepository.findByName(form.getClient()).get(0);
        List<String> replacedString = Arrays.stream(form.getGoodsAndAmounts().split(","))
                .map(str -> str.replaceAll("\n", ""))
                .collect(Collectors.toList());
        Map<String, Integer> stringMap = new LinkedHashMap<>();
        List<Pair<Good, Integer>> finalMap = new ArrayList<>();
        replacedString.stream()
                .map(str -> str.split("-"))
                .forEach(strArray -> stringMap.put(strArray[0], Integer.valueOf(strArray[1])));
        stringMap.entrySet()
                .forEach(entry -> finalMap.add(new Pair<>(goodMongoRepository.findByName(entry.getKey()).get(0), entry.getValue())));
        Order order = new Order(client, finalMap,
                LocalDate.parse(form.getPurchaseDate()), form.getIsWholeSale(), form.getDiscount(), form.getDescription());
        orderService.create(order);
        return new ModelAndView("redirect:/gui/orders/all", model);
    }

    @RequestMapping("/update/{id}")
    public String update(ModelMap model, @PathVariable String id) {
        Order order = orderService.get(id);
        OrderForm orderForm = new OrderForm(order);
        model.addAttribute("form", orderForm);
        return "order-update";
    }

    @PostMapping("/update/{id}")
    public ModelAndView update2(ModelMap model, @ModelAttribute("form") OrderForm form, @PathVariable String id) {
        Order order = orderService.get(id);
        Client client = clientMongoRepository.findByName(form.getClient()).get(0);
        List<String> replacedString = Arrays.stream(form.getGoodsAndAmounts().split(","))
                .map(str -> str.replaceAll("\n", ""))
                .collect(Collectors.toList());
        Map<String, Integer> stringMap = new LinkedHashMap<>();
        List<Pair<Good, Integer>> finalMap = new ArrayList<>();
        replacedString.stream()
                .map(str -> str.split("-"))
                .forEach(strArray -> stringMap.put(strArray[0], Integer.valueOf(strArray[1])));
        stringMap.entrySet()
                .forEach(entry -> finalMap.add(new Pair<>(goodMongoRepository.findByName(entry.getKey()).get(0), entry.getValue())));
        order.setGoodToAmountMap(finalMap);
        order.setClient(client);
        order.setWholeSale(form.getIsWholeSale());
        order.setDiscount(form.getDiscount());
        order.setPurchaseDate(LocalDate.parse(form.getPurchaseDate()));
        order.setDescription(form.getDescription());
        orderService.update(order);
        return new ModelAndView("redirect:/gui/orders/all", model);
    }

    private Map<String, String> getClientsMap() {
        Map<String, String> clientsMap = new LinkedHashMap<>();
        List<Client> clients = clientService.getAll();
        clients.stream()
                .map(Client::getName)
                .forEach(stringName -> clientsMap.put(stringName, stringName));
        return clientsMap;
    }
}
