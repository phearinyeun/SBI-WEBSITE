package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;

import java.util.List;
import java.util.Optional;

public interface LoginService {
    Optional<RegisterModel> userLoginOption();
    List<RegisterModel> findbyId(Long id);
    RegisterModel userlogin (Long id);
}
