package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;

import java.util.List;

public interface RegisterService {
    RegisterModel create(RegisterModel registerModel);
    List<RegisterModel> findAll(RegisterModel registerModel);
}
