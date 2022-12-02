package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.UserLogin;
import org.apache.catalina.User;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

public interface LoginService {
    Optional<UserLogin> userLoginOption
    List<UserLogin> findbyId(Long id);
    UserLogin userlogin (Long id);
}
