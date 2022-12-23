package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.exception.respone.Response;
import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.RegisterServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final RegisterServiceImpl registerService;

    public RegisterController(RegisterServiceImpl registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/testing")
    public String register(Model model){
        RegisterModel registerModel = new RegisterModel();
        model.addAttribute("register", registerModel);
        return "register";
    }

    @PostMapping("/create")
    public Response create (@RequestBody RegisterModel registerModel){
        return new Response(200, "Success", registerService.create(registerModel));
    }
}
