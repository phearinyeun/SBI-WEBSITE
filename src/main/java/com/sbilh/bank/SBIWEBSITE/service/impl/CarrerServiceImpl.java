package com.sbilh.bank.SBIWEBSITE.service.impl;

import com.sbilh.bank.SBIWEBSITE.exception.NotFoundException;
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
        log.info("Success create  {} ", carrerModel);
        return carrerRepository.save(carrerModel);
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<CarrerModel> carrerModel = carrerRepository.findById(id);
        if (carrerModel.isPresent()){
            log.info("Success deleted by Id {}", id);
            carrerRepository.deleteById(id);
            return true;
        }
        log.info("Could not found the ID {}", id);
        throw new NotFoundException(id, "Could not found the ID ", id.toString());
    }

    @Override
    public CarrerModel update (CarrerModel carrerModel, Long id) {
        Optional<CarrerModel> carrerModelOptional = carrerRepository.findById(id);
        if(carrerModelOptional.isPresent()){
            carrerModel.setId(id);
            carrerRepository.save(carrerModel);
            log.info("Carrer is updated {}", carrerModel);
            return carrerModel;
        }
        log.info("Could now found id {}",id);
        throw new NotFoundException(id, "Could not found the ID {} ", id.toString());
    }

    @Override
    public List<CarrerModel> findAll(CarrerModel carrerModel) {
        List<CarrerModel> carrerModelList = carrerRepository.findAll();
        log.info("Get all carrer: {}",carrerModel);
        return carrerRepository.findAll();
    }

    @Override
    public List<CarrerModel> findAllByJobTitle(String jobTitle, Pageable pageable) {
        List<CarrerModel> carrerModelList = carrerRepository.findAllByJobTitle(jobTitle,pageable);
        if (!carrerModelList.isEmpty()){
            log.info("Find by Carrer {} ", jobTitle);
            carrerRepository.findAllByJobTitle(jobTitle, pageable);
            return carrerModelList;
        }
        log.info(jobTitle, "Could not found the job title", jobTitle);
        throw new NotFoundException(jobTitle,"Could not found the job title",jobTitle);
    }

    @Override
    public CarrerModel findById(Long id) {
        Optional<CarrerModel> carrerModel = carrerRepository.findById(id);
        if (carrerModel.isPresent()) {
            log.info("Success Get Carrer by {} {}", id, carrerModel);
            return carrerRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        }
        log.info("Could not found ID {} ",id);
        throw new NotFoundException(id,"Could not found the ID :", id.toString());
    }
}
