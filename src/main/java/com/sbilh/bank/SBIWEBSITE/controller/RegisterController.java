package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private final RegisterServiceImpl registerServiceImpl;

    public RegisterController(RegisterServiceImpl registerServiceImpl) {
        this.registerServiceImpl = registerServiceImpl;
    }

    @GetMapping
    public List<RegisterModel> findAll(RegisterModel registerModel){
        return registerServiceImpl.findAll(registerModel);
    }

    @GetMapping("findid/{id}")
    public Optional<RegisterModel> findById(@PathVariable ("id") Long id){
        return registerServiceImpl.findById(id);
    }

    @GetMapping("/findname")
    public List<RegisterModel> findFirstname(@Param("firstName") String firstName,
                                             @Param("lastName") String lastName){
        return registerServiceImpl.findFirstname(firstName, lastName);
    }

    @GetMapping("/delete/{id}")
    public Optional<RegisterModel> registerModel(@PathVariable ("id") Long id){
        registerServiceImpl.deleteById(id);
        return null;
    }

    @PostMapping
    public RegisterModel create(@RequestBody @Valid RegisterModel registerModel){
        return registerServiceImpl.create(registerModel);
    }


}
