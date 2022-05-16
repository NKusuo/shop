package com.company.shop.controller;

import com.company.shop.Service.ClientService;
import com.company.shop.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private ClientService clientService;


    @GetMapping("/registration.html")
    public String registration(Model model) {
        model.addAttribute("clientForm", new Client());
        return "registration.html";
    }

    @PostMapping("/registration.html")
    public String addClient(@ModelAttribute("clientForm") Client clientForm, Model model) {

        if (!clientService.createClient(clientForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "usernameError.html";
        }

        return "entry.html";
    }
}
