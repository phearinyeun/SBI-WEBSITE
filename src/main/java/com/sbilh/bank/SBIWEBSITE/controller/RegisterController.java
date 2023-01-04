package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.exception.respone.Response;
import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.RegisterServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String create(final @Valid RegisterModel registerModel ,final Model model) {
        Response res = new Response(200, "Success", registerService.create(registerModel));
        model.addAttribute("res", res);
        model.addAttribute("register", registerService.findAll());
        return "home";
    }

    @GetMapping("/delete")
    public String delete (@RequestParam Long id, RedirectAttributes redirectAttributes){
        try {
            boolean existed = registerService.deleteById(id);

            if(existed){
                redirectAttributes.addFlashAttribute("message", "Delete user successfully" + id);
            } else {
                redirectAttributes.addFlashAttribute("message", "The id does not exist");
            }
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("message",
                    "Could not delete the file: " + id + ". Error: " + e.getMessage());
        }
        return "redirect:/home";
    }
}
