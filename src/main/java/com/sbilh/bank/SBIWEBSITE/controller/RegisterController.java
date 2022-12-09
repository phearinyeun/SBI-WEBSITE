package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.RegisterServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final RegisterServiceImpl registerService;

    public RegisterController(RegisterServiceImpl registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/registers")
    public String  register(Model model){
        RegisterModel registerModel = new RegisterModel();
        model.addAttribute("register", registerModel);
        return "register";
    }

    @GetMapping
    public List<RegisterModel> findAll(RegisterModel registerModel){
        return registerService.findAll(registerModel);
    }

    @PostMapping
    public RegisterModel create(RegisterModel registerModel){
        registerService.create(registerModel);
        return registerModel;
    }
}
