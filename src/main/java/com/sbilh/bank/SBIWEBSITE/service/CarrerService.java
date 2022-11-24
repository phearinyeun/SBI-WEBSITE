package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.CarrerModel;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CarrerService {
    CarrerModel create(CarrerModel carrerModel);
    List<CarrerModel> findAll();
    CarrerModel findByCarrer(String carrerTitle);
    List<CarrerModel> findAllByJobTitle(String jobTitle, Pageable pageable);
    CarrerModel findById(Long id);
    CarrerModel deleteByJobId (Long jobid);

}
