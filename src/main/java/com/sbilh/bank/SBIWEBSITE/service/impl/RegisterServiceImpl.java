package com.sbilh.bank.SBIWEBSITE.service.impl;

import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;
import com.sbilh.bank.SBIWEBSITE.repository.RegisterRepository;
import com.sbilh.bank.SBIWEBSITE.service.RegisterService;
import jdk.jshell.spi.ExecutionControl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {
    private final RegisterRepository registerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public RegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public RegisterModel create(RegisterModel registerModel) {
        return registerRepository.save(registerModel);
    }

    @Override
    public void register(RegisterModel registerModel) {
    }

    @Override
    public Optional<RegisterModel> deleteById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<RegisterModel> update(RegisterModel registerModel) {
        return Optional.empty();
    }

    @Override
    public List<RegisterModel> findAll() {
        return registerRepository.findAll();
    }

    @Override
    public List<RegisterModel> findById(Long id) {
        return null;
    }

    @Override
    public Optional<RegisterModel> findByFirstname(String email) {
        return Optional.empty();
    }
}
