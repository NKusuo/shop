package com.company.shop.controller;

import com.company.shop.Service.OrderService;
import com.company.shop.Service.ProductsService;
import com.company.shop.domain.Orders;
import com.company.shop.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.Order;
import java.util.List;

@Controller
public class AcceptedOrdersController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductsService productsService;

    @GetMapping("/AcceptedOrders.html")
    public String AcceptedOrders(Model model) {
        List<Orders> allOrders = orderService.allOrders();
        model.addAttribute("allOrders",allOrders);
        return "AcceptedOrders.html";
    }

    @PostMapping("/AcceptedOrders.html")
    public String statusOrder(@RequestParam String status,@RequestParam Integer id, Model model) {
        if(!status.equals("В обработке") && !status.equals("Завершен")){
            model.addAttribute("errorStatus","Введите \"В обработке\" или \"Завершен\"!");
            return "AcceptedOrders.html";
        }
        orderService.updateStatus(id,status);
        return "redirect:/AcceptedOrders.html";
    }


}
