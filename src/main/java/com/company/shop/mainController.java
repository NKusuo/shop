package com.company.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mainController {

    @GetMapping("/2")
    public String main( ) {
        return "2";
    }

    @GetMapping("/registration.html")
    public String registration( ) {
        return "registration.html";
    }
}
