package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;

import java.util.List;
import java.util.Optional;

public interface RegisterService {
    RegisterModel create(RegisterModel registerModel);
    List<RegisterModel> findAll(RegisterModel registerModel);
    Optional<RegisterModel> findById(Long id);
    List<RegisterModel> findFirstname(String firstName, String lastName);
    Optional<RegisterModel> deleteById(Long id);

}
