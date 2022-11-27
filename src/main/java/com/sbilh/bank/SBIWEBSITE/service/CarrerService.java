package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.CarrerModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarrerService {
    CarrerModel create(CarrerModel carrerModel);
    CarrerModel deleteById (Long id);

    List<CarrerModel> findAll();
    CarrerModel findByCarrer(String carrerTitle);
//    @Query("SELECT jobtitle FROM Carrer jobtitle WHERE jobtiel.jobtitle = ?1")
    @Query("SELECT * FROM Carrer WHERE Carrer = jobtitle")
    List<CarrerModel> findAllByJobTitle(String jobtitle, Pageable pageable);
    CarrerModel findById(Long id);
    CarrerModel deleteByJobId (Long jobid);

}
