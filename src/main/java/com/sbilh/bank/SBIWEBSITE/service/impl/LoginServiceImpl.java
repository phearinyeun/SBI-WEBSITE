package com.sbilh.bank.SBIWEBSITE.service.impl;

import com.sbilh.bank.SBIWEBSITE.model.UserLogin;
import com.sbilh.bank.SBIWEBSITE.repository.LoginRepository;
import com.sbilh.bank.SBIWEBSITE.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    @Override
    public List<UserLogin> findbyId(Long id) {
        loginRepository.findById(id);
        return null;
    }

    @Override
    public UserLogin userlogin(Long id) {
        if (id.equals(findbyId(id))) {
            return null;
        }
        return new UserLogin();
    }
}