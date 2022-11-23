package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.model.CarrerModel;
import com.sbilh.bank.SBIWEBSITE.service.CarrerServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrer")
public class CarrerController {
    private final CarrerServiceImpl carrerServiceImpl;

    public CarrerController(CarrerServiceImpl carrerServiceImpl) {
        this.carrerServiceImpl = carrerServiceImpl;
    }

    @GetMapping
    public String findAll(){
        carrerServiceImpl.findAll();
        return null;
    }

    @GetMapping("/{carrerTitle}")
    public CarrerModel findByCarrer(@PathVariable ("carrerTitle") String carrerTitle){
        return carrerServiceImpl.findByCarrer(carrerTitle);
    }
    @GetMapping()
    public List<CarrerModel> findAllByJobTitle(Pageable pageable){
        return carrerServiceImpl.findAllByJobTitle("a%", pageable);
    }

    @GetMapping("/{id}")
    public CarrerModel getCarrerById(@PathVariable ("id") Long id){
        return carrerServiceImpl.findById(id);
    }

    @PostMapping("/create")
    public String createCarrer(@PathVariable ("create") String create){
        return "";
//        return carrerServiceImpl.
    }
}
