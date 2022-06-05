package com.company.shop.controller;

import com.company.shop.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class entryAdminController {
    @Autowired
    private AdminService adminService;


    @GetMapping("/entryAdm.html")
    public String entryAdm( Model model) {
        return "entryAdm.html";
    }

    @PostMapping("/entryAdm.html")
    public String entryPostAdm(@RequestParam String log, @RequestParam  String psw, Model model) {
        if(!adminService.findByPassAndLogin(log, psw)){
            model.addAttribute("errorData","НЕВЕРНЫЕ ДАННЫЕ!");
            return "entryAdm.html";
        }
        return "redirect:/menuAdm.html";
    }

}
