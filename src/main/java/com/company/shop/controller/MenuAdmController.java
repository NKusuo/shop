package com.company.shop.controller;


import com.company.shop.Service.ProductsService;
import com.company.shop.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MenuAdmController {
    @Autowired
    private ProductsService productsService;


   @GetMapping("/menuAdm.html")
    public String newProduct(Model model) {
        return "menuAdm.html";
    }

    @PostMapping("/menuAdm.html")
    public String addProductNew(@RequestParam String title,@RequestParam  Integer amount,@RequestParam Integer price,@RequestParam String description, Model model) {
        Products newProduct = new Products(title,description, amount, price);

        if (!productsService.createProduct(newProduct)){
            return "usernameError.html";
        }
        return "redirect:/menuAdm.html";
    }
    @PostMapping("/menuAdm/updateAmount.html")
    public String updateAmount(@RequestParam Integer amount,@RequestParam Integer id, Model model) {
        productsService.updateAmount(id,amount);
        return "redirect:/menuAdm.html";
    }
}
