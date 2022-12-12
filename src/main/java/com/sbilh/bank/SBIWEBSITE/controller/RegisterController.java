package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private final RegisterServiceImpl registerServiceImpl;

    public RegisterController(RegisterServiceImpl registerServiceImpl) {
        this.registerServiceImpl = registerServiceImpl;
    }

//    @GetMapping("/registers")
//    public String  register(Model model){
//        RegisterModel registerModel = new RegisterModel();
//        model.addAttribute("register", registerModel);
//        return "register";
//    }

    @GetMapping
    public List<RegisterModel> findAll(RegisterModel registerModel){
        return registerServiceImpl.findAll(registerModel);
    }

    @PostMapping
    public RegisterModel create(@RequestBody @Valid RegisterModel registerModel){
        return registerServiceImpl.create(registerModel);
    }
}
