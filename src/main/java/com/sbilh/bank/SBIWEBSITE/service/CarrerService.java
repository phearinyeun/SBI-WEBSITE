package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.CarrerModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarrerService {
    Iterable<CarrerModel> findAll();
    CarrerModel findByCarrer(String carrerTitle);
    List<CarrerModel> findAllByJobTitle(String jobTitle, Pageable pageable);
    CarrerModel findById(Long id);
    void createCarrer(CarrerModel carrerModel);
}
