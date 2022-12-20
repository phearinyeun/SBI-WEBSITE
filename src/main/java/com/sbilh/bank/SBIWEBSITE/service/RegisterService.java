package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.UserLoginModel;

import java.util.List;
import java.util.Optional;

public interface RegisterService {
    UserLoginModel create(UserLoginModel registerModel);
    List<UserLoginModel> findAll(UserLoginModel registerModel);
    Optional<UserLoginModel> findById(Long id);
    List<UserLoginModel> findFirstname(String firstName, String lastName);
    Optional<UserLoginModel> deleteById(Long id);

}
