package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.exception.CarrerException;
import com.sbilh.bank.SBIWEBSITE.model.CarrerModel;
import com.sbilh.bank.SBIWEBSITE.repository.CarrerRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrerServiceImpl implements CarrerService  {

    public final CarrerRepository carrerRepository;

    public CarrerServiceImpl(CarrerRepository carrerRepository) {
        this.carrerRepository = carrerRepository;
    }
    @Override
    public CarrerModel create(CarrerModel carrerModel) {
        return carrerRepository.save(carrerModel);
    }
    @Override
    public List<CarrerModel> findAll() {
        return carrerRepository.findAll();
    }
    @Override
    public CarrerModel findByCarrer(String carrerTitle) {
        return carrerRepository.findByJobTitle(carrerTitle).orElse(null);
    }
    @Override
    public List<CarrerModel> findAllByJobTitle(String jobTitle, Pageable pageable) {
        return carrerRepository.findAllByJobTitle(jobTitle, pageable);
    }
    @Override
    public CarrerModel findById(Long id) {
        return carrerRepository.findById(id).orElseThrow(() -> new CarrerException("Carrer doesn't exist!"));
    }

    @Override
    public CarrerModel deleteByJobId(Long jobid) {
        return carrerRepository.deleteByJobId(jobid);
    }
}
