package com.company.shop.controller;

import com.company.shop.Service.AdminService;
import com.company.shop.Service.ClientService;
import com.company.shop.Service.OrderService;
import com.company.shop.Service.ProductsService;
import com.company.shop.domain.Client;
import com.company.shop.domain.Orders;
import com.company.shop.domain.Products;
import com.company.shop.domain.addProd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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
    private ProductsService productsService;

    @GetMapping("/menu.html")
    public String menu(Model model) {
        List<Products> allProducts = productsService.allProducts();
        model.addAttribute("allProducts",allProducts);
        return "menu.html";
    }

    @PostMapping("/menu.html")
    public String addProducts(@ModelAttribute(value="addProd") addProd listCheck){
        List<Integer> checkedItems = listCheck.getCheckedItems();
        ArrayList<Products> newOrder=new ArrayList<Products>();
        for(int i=0;i<checkedItems.size();++i){
            Integer id = checkedItems.get(i);
            Products p=productsService.findAllById(id);
            newOrder.add(p);
            productsService.updateAmount(p.getIdProduct(),p.getAmount()-1);
        }
        Integer price =0;
        for(int i=0;i<checkedItems.size();++i){
            price += newOrder.get(i).getPrice();
        }

        Orders order = new Orders(client.getIdClient(),"В обработке", new Date(), price,newOrder);
        orderService.createOrder(order);
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


    @Autowired
    private OrderService orderService;

    @GetMapping("/history.html")
    public String history(Model model) {
        List<Orders> listOrders = orderService.findAllByIdClient(client.getIdClient());
        model.addAttribute("listOrders",listOrders);
        return "history.html";
    }



    @GetMapping("/statProducts.html")
    public String statProducts( ) {
        return "statProducts.html";
    }

    @GetMapping("/err404.html")
    public String err404( ) {
        return "err404.html";
    }
}
