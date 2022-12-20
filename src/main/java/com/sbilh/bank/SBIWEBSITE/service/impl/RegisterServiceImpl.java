package com.sbilh.bank.SBIWEBSITE.service.impl;

import com.sbilh.bank.SBIWEBSITE.model.UserLoginModel;
import com.sbilh.bank.SBIWEBSITE.repository.RegisterRepository;
import com.sbilh.bank.SBIWEBSITE.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private final RegisterRepository registerRepository;

    public RegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public UserLoginModel create(UserLoginModel registerModel) {
        return registerRepository.save(registerModel);

    }

    @Override
    public List<UserLoginModel> findAll(UserLoginModel registerModel) {
        return registerRepository.findAll();
    }

    @Override
    public Optional<UserLoginModel> findById(Long id) {
        return registerRepository.findById(id);
    }

    @Override
    public List<UserLoginModel> findFirstname(String firstName, String lastName) {
        return registerRepository.findFirstname(firstName, lastName);
    }

    @Override
    public Optional<UserLoginModel> deleteById(Long id) {
        registerRepository.deleteById(id);
        return null;
    }
}
