package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.exception.respone.Response;
import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.RegisterServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final RegisterServiceImpl registerService;

    public RegisterController(RegisterServiceImpl registerService) {
        this.registerService = registerService;
    }

    @GetMapping
    public String register(Model model){
        RegisterModel registerModel = new RegisterModel();
        model.addAttribute("register", registerModel);
        return "register";
    }
    private List<RegisterModel> getAllRegister(){
        return registerService.findAll();
    }
    @PostMapping("/create")
//    public Response create(@RequestBody RegisterModel registerModel){
    public String create(@Valid  RegisterModel  registerModel, final BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            return "register";
        }
        Response res = new Response(200, "Success", registerService.create(registerModel));
        model.addAttribute("res", res);
        return "register";
    }

    @GetMapping("/getall")
    public Response findAll(@RequestBody RegisterModel registerModel){
        return new Response(200, "Success", registerService.findAll());
    }
}
