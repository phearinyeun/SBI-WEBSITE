package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.model.UserLoginModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    public List<UserLoginModel> findAll(UserLoginModel registerModel){
        return registerServiceImpl.findAll(registerModel);
    }

    @GetMapping("findid/{id}")
    public Optional<UserLoginModel> findById(@PathVariable ("id") Long id){
        return registerServiceImpl.findById(id);
    }

    @GetMapping("/findname")
    public List<UserLoginModel> findFirstname(@Param("firstName") String firstName,
                                              @Param("lastName") String lastName){
        return registerServiceImpl.findFirstname(firstName, lastName);
    }

    @GetMapping("/delete/{id}")
    public Optional<UserLoginModel> registerModel(@PathVariable ("id") Long id){
        registerServiceImpl.deleteById(id);
        return null;
    }

    @PostMapping
    public UserLoginModel create(@RequestBody @Valid UserLoginModel registerModel){
        return registerServiceImpl.create(registerModel);
    }


}
