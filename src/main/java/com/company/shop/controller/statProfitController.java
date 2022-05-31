package com.company.shop.controller;

import com.company.shop.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class statProfitController {

    @Autowired
    ProductsService productsService;

    @GetMapping("/statProfit.html")
    public String stat( Model model) {
        //model.addAttribute("listProducts",productsService.statProducts());
        return "statProfit.html";
    }

}
