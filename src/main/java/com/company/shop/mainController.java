package com.company.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class mainController {

    @GetMapping("/2.html")
    public String main( ) {
        return "2.html";
    }

    @GetMapping("/registration.html")
    public String registration( ) {
        return "registration.html";
    }

    @GetMapping("/AcceptedOrders.html")
    public String AcceptedOrders( ) {
        return "AcceptedOrders.html";
    }

    @GetMapping("/Catalog.html")
    public String Catalog( ) {
        return "Catalog.html";
    }

    @GetMapping("/entry.html")
    public String entry( ) {
        return "entry.html";
    }

    @GetMapping("/entryAdm.html")
    public String entryAdm( ) {
        return "entryAdm.html";
    }

    @GetMapping("/history.html")
    public String history( ) {
        return "history.html";
    }

    @GetMapping("/menu.html")
    public String menu( ) {
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
}
