package com.company.shop.controller;

import com.company.shop.Service.AdminService;
import com.company.shop.Service.ClientService;
import com.company.shop.Service.OrderService;
import com.company.shop.Service.ProductsService;
import com.company.shop.domain.Client;
import com.company.shop.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Controllers {

   @GetMapping("/2.html")
    public String main( ) {
        return "2.html";
    }

    @Autowired
    private ClientService clientService;
    private Client client;

    @GetMapping("/entry.html")
    public String entry( Model model) {
        return "entry.html";
    }

    @PostMapping("/entry.html")
    public String entryPost(@RequestParam String log,@RequestParam  String psw,  Model model) {

        if(!clientService.findByPassAndLogin(log, psw)){
            /* model.addAttribute("errorData","Неверные данные!");*/
            return "entry.html";
        }
        client = clientService.findByLogin(log);
        return "redirect:/menu.html";
    }

    @Autowired
    private AdminService adminService;


    @GetMapping("/entryAdm.html")
    public String entryAdm( Model model) {
        return "entryAdm.html";
    }

    @PostMapping("/entryAdm.html")
    public String entryPostAdm(@RequestParam String log, @RequestParam  String psw, Model model) {
        if(!adminService.findByPassAndLogin(log, psw)){
            /* model.addAttribute("errorData","Неверные данные!");*/
            return "entryAdm.html";
        }
        return "redirect:/menuAdm.html";
    }

    @GetMapping("/AcceptedOrders.html")
    public String AcceptedOrders( ) {
        return "AcceptedOrders.html";
    }


    @Autowired
    private OrderService orderService;

    @GetMapping("/history.html")
    public String history(Model model) {
        List<Orders> listOrders = orderService.findAllByIdClient(client.getIdClient());
        model.addAttribute("Orders",listOrders);
        return "history.html";
    }



    @GetMapping("/menuAdm.html")
    public String menuAdm( ) {
        return "menuAdm.html";
    }

    @GetMapping("/statProducts.html")
    public String statProducts( ) {
        return "statProducts.html";
    }

    @GetMapping("/statProfit.html")
    public String statProfit( ) {
        return "statProfit.html";
    }

    @GetMapping("/err404.html")
    public String err404( ) {
        return "err404.html";
    }
}
