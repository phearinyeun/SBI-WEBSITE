package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.LoginModel;

import java.util.List;
import java.util.Optional;

public interface LoginService {
    Optional<LoginModel> userLoginOption();
    List<LoginModel> findbyId(Long id);
    LoginModel userlogin (Long id);
}
