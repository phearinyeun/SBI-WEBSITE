package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.LoginServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("register")
public class RegisterController {
    private final LoginServiceImpl loginServiceImpl;

    public RegisterController(LoginServiceImpl loginServiceImpl) {
        this.loginServiceImpl = loginServiceImpl;
    }

    @GetMapping
    public String RegisterUser (WebRequest request, Model model) {
        RegisterModel register = new RegisterModel();
        model.addAttribute("register", register);
        return "register";
    }
}
