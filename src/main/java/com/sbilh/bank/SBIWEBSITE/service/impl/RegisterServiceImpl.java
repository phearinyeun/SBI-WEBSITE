package com.sbilh.bank.SBIWEBSITE.service.impl;

import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;
import com.sbilh.bank.SBIWEBSITE.repository.RegisterRepository;
import com.sbilh.bank.SBIWEBSITE.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
    public RegisterModel create(RegisterModel registerModel) {
        return registerRepository.save(registerModel);

    }

    @Override
    public List<RegisterModel> findAll(RegisterModel registerModel) {
        return registerRepository.findAll();
    }

    @Override
    public Optional<RegisterModel> findById(Long id) {
        return registerRepository.findById(id);
    }

    @Override
    public List<RegisterModel> findFirstname(String firstName, String lastName) {
        return registerRepository.findFirstname(firstName, lastName);
    }

    @Override
    public Optional<RegisterModel> deleteById(Long id) {
        registerRepository.deleteById(id);
        return null;
    }
}
