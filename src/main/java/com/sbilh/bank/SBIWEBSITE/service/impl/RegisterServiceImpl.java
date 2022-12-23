package com.sbilh.bank.SBIWEBSITE.service.impl;

import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;
import com.sbilh.bank.SBIWEBSITE.repository.RegisterRepository;
import com.sbilh.bank.SBIWEBSITE.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {
    private final RegisterRepository registerRepository;

    public RegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public RegisterModel create(RegisterModel registerModel) {
        log.info("Success create {}", registerModel);
        return registerRepository.create(registerModel);
    }

////
////    @Override
////    public List<RegisterModel> findAll(RegisterModel registerModel) {
////        log.info("Get All {} ", registerModel);
////        return registerRepository.findAll();
////    }
////
////    @Override
////    public Optional<RegisterModel> findById(Long id) {
////        return Optional.empty();
////    }
////
////    @Override
////    public Optional<RegisterModel> findByFirstname(String firstname) {
////        return Optional.empty();
////    }
////
////    @Override
////    public Optional<RegisterModel> deleteById(Long id) {
////        return Optional.empty();
////    }
////
////    @Override
////    public Optional<RegisterModel> deleteByFirstname(String firstname) {
////        return Optional.empty();
////    }
////
////    @Override
////    public Optional<RegisterModel> update(Long id) {
////        return Optional.empty();
////    }
}
