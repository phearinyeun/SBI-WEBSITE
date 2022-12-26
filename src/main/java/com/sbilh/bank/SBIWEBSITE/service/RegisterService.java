package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;

import java.util.List;
import java.util.Optional;

public interface RegisterService {
    RegisterModel create (RegisterModel registerModel);
    Optional<RegisterModel> deleteById(Long id);
    Optional<RegisterModel> update(RegisterModel registerModel);
    List<RegisterModel> findAll();
    List<RegisterModel> findById(Long id);
    Optional<RegisterModel> findByFirstname(String email);
}
