package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.extra.carrer.ResponseCarrer;
import com.sbilh.bank.SBIWEBSITE.model.CarrerModel;
import com.sbilh.bank.SBIWEBSITE.service.CarrerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/carrer")
@Slf4j
public class CarrerController {
    private final CarrerServiceImpl carrerServiceImpl;

    public CarrerController(CarrerServiceImpl carrerServiceImpl) {
        this.carrerServiceImpl = carrerServiceImpl;
    }
    @PostMapping("/create")
    public CarrerModel createCarrer(@RequestBody @Valid CarrerModel carrerModel){
        return carrerServiceImpl.create(carrerModel);
    }
    @GetMapping
    public ResponseCarrer findAll(){
        List<CarrerModel> carrerModelList = carrerServiceImpl.findAll();
        log.info("Get all carrer: {}",carrerModelList);
        return new ResponseCarrer(200, "success",carrerModelList);
    }
    @GetMapping("findby/{id}")
    public ResponseCarrer findById(@PathVariable("id") Long id){
        log.info("Get Carrer by {}",id);
        CarrerModel model = carrerServiceImpl.findById(id);
        log.info("success get by {} {}",id,model);
       return new ResponseCarrer(200,"success",model);

    }
    @GetMapping("/{carrerTitle}")
    public CarrerModel findByCarrer(@PathVariable ("carrerTitle") String carrerTitle){
        return carrerServiceImpl.findByCarrer(carrerTitle);
    }
    @GetMapping("/findbytitle")
    public List<CarrerModel> findAllByJobTitle(Pageable pageable){
        return carrerServiceImpl.findAllByJobTitle("a%", pageable);
    }
    @GetMapping("/{id}")
    public CarrerModel getCarrerById(@PathVariable ("id") Long id){
        return carrerServiceImpl.findById(id);
    }

    @PostMapping("{jobid}")
    public CarrerModel deleteByJobTitle(@PathVariable ("jobid") Long jobid){
        return carrerServiceImpl.deleteByJobId(jobid);
    }
}
