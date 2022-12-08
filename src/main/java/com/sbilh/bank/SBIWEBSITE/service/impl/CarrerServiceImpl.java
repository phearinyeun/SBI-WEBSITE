package com.sbilh.bank.SBIWEBSITE.service.impl;

import com.sbilh.bank.SBIWEBSITE.exception.CarrerNotFoundException;
import com.sbilh.bank.SBIWEBSITE.model.CarrerModel;
import com.sbilh.bank.SBIWEBSITE.repository.CarrerRepository;
import com.sbilh.bank.SBIWEBSITE.service.CarrerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CarrerServiceImpl implements CarrerService {

    public final CarrerRepository carrerRepository;

    public CarrerServiceImpl(CarrerRepository carrerRepository) {
        this.carrerRepository = carrerRepository;
    }
    @Override
    public CarrerModel createCarrer(CarrerModel carrerModel) {
        log.info("Carrer Added {} ", carrerModel);
        return carrerRepository.save(carrerModel);
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<CarrerModel> carrerModel = carrerRepository.findById(id);
        if (carrerModel.isPresent()){
            carrerRepository.deleteById(id);
            return true;
        }
        CarrerNotFoundException exception = new CarrerNotFoundException(id);
        return false;
    }

    @Override
    public CarrerModel save(CarrerModel carrerModel, Long id) {
        Optional<CarrerModel> carrerModelOptional = carrerRepository.findById(id);
        if(carrerModelOptional.isPresent()){
            carrerModel.setId(id);
            carrerRepository.save(carrerModel);
            log.info("Carrer is updated {}", carrerModel);
            return carrerModel;
        }
        CarrerNotFoundException exception = new CarrerNotFoundException(id);
        log.info("Could now found id {}",id);
        return null;
    }

    @Override
    public List<CarrerModel> findAll(CarrerModel carrerModel) {
        log.info("Get all carrer: {}",carrerModel);
        return carrerRepository.findAll();
    }

    @Override
    public List<CarrerModel> findAllByJobTitle(String jobTitle, Pageable pageable) {
        log.info("Find by Carrer {} ", jobTitle);
        return carrerRepository.findAllByJobTitle(jobTitle, pageable);
    }

    @Override
    public CarrerModel findById(Long id) {
        Optional<CarrerModel> carrerModel = carrerRepository.findById(id);
        if (carrerModel.isPresent()) {
            log.info("Get Carrer by {}", id);
//            Optional<CarrerModel> carrerModel = carrerRepository.findById(id);
            log.info("Success Get Carrer by {} {}", id, carrerModel);
            return carrerRepository.findById(id).orElseThrow(() -> new CarrerNotFoundException(id));
        }
        CarrerNotFoundException carrerNotFoundException = new CarrerNotFoundException(id);
        return null;
    }
}
