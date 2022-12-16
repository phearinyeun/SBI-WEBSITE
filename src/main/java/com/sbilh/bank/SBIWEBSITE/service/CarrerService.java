package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.CarrerModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarrerService {
    CarrerModel createCarrer(CarrerModel carrerModel);
    boolean deleteById (Long id);
    CarrerModel update (CarrerModel carrerModel, Long id);
    List<CarrerModel> findAll(CarrerModel carrerModel);
//    @Query("SELECT j FROM CarrerModel j WHERE j.jobTitle =:jobTitle")
    List<CarrerModel> findAllByJobTitle(String jobtitle, Pageable pageable);
    CarrerModel findById(Long id);

}
