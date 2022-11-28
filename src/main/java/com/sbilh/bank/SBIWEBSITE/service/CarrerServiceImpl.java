package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.exception.CarrerException;
import com.sbilh.bank.SBIWEBSITE.model.CarrerModel;
import com.sbilh.bank.SBIWEBSITE.repository.CarrerRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrerServiceImpl implements CarrerService  {

    public final CarrerRepository carrerRepository;

    public CarrerServiceImpl(CarrerRepository carrerRepository) {
        this.carrerRepository = carrerRepository;
    }
    @Override
    public CarrerModel addCarrer(CarrerModel carrerModel) {
        return carrerRepository.save(carrerModel);
    }

    @Override
    public CarrerModel deleteById(Long id) {
        carrerRepository.deleteById(id);
        return null;
    }

    @Override
    public CarrerModel save(CarrerModel carrerModel, Long id) {
        Optional<CarrerModel> carrerModelOptional = carrerRepository.findById(id);
        if(carrerModelOptional.isPresent()){
            carrerModel.setId(id);
            carrerRepository.save(carrerModel);
            return carrerModel;
        }
        return null;
    }

    @Override
    public List<CarrerModel> findAll() {
        return carrerRepository.findAll();
    }

    @Override
    public List<CarrerModel> findAllByJobTitle(String jobTitle, Pageable pageable) {
        return carrerRepository.findAllByJobTitle(jobTitle, pageable);
    }
    @Override
    public CarrerModel findById(Long id) {
        return carrerRepository.findById(id).orElseThrow(() -> new CarrerException("Carrer doesn't exist!"));
    }
}
