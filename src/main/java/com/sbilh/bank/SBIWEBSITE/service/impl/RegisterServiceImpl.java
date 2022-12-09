package com.sbilh.bank.SBIWEBSITE.service.impl;

import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;
import com.sbilh.bank.SBIWEBSITE.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {
    public final RegisterService registerService;

    public RegisterServiceImpl(RegisterService registerService) {
        this.registerService = registerService;
    }

    @Override
    public RegisterModel create(RegisterModel registerModel) {
        registerService.create(registerModel);
        return registerModel;
    }

    @Override
    public List<RegisterModel> findAll(RegisterModel registerModel) {
        return registerService.findAll(registerModel);
    }
}
