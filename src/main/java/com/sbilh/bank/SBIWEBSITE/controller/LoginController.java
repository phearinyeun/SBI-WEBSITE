package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.model.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model){
        LoginModel loginModel = new LoginModel();
        model.addAttribute("login", loginModel);
        return "/login";
    }
}
