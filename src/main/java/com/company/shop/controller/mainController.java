package com.company.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
    @GetMapping("/2.html")
    public String main( ) {
        return "2.html";
    }
    @GetMapping("/err404.html")
    public String err404( ) {
        return "err404.html";
    }
}
