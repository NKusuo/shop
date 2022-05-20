package com.company.shop.controller;

import com.company.shop.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class mainController {

   /* @GetMapping("/2.html")
    public String main( ) {
        return "2.html";
    }*/


    @GetMapping("/AcceptedOrders.html")
    public String AcceptedOrders( ) {
        return "AcceptedOrders.html";
    }

    @GetMapping("/Catalog.html")
    public String Catalog( ) {
        return "Catalog.html";
    }

    @GetMapping("/entryAdm.html")
    public String entryAdm( ) {
        return "entryAdm.html";
    }


    @GetMapping("/history.html")
    public String history( ) {
        return "history.html";
    }

    @Autowired
    private ProductsService productsService;

    @GetMapping("/menu.html")
    public String menu(Model model) {
        model.addAttribute("Products",productsService.allProducts());
        return "menu.html";
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
