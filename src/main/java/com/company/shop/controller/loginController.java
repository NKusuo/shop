package com.company.shop.controller;

import com.company.shop.Service.ClientService;
import com.company.shop.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loginController {

    @Autowired
    private ClientService clientService;

/*
    @GetMapping("/login.html")
    public String entry(Model model) {

        return "login.html";
    }

/*
    @PostMapping("/login.html")
    public String checkEntry(@ModelAttribute("clientForm") Client clientForm, Model model) {

        if (!clientService.findByPassAndLogin(clientForm)){
            String dataError="Неверные даннные";
            model.addAttribute("dataError", dataError);
            return "login.html";
        }

        return "menu.html";
    }*/
}
