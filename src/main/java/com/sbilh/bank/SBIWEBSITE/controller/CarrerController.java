package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.exception.CarrerNotFoundException;
import com.sbilh.bank.SBIWEBSITE.extra.carrer.ResponseCarrer;
import com.sbilh.bank.SBIWEBSITE.model.CarrerModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.CarrerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrer")
@Slf4j
public class CarrerController {
    private final CarrerServiceImpl carrerServiceImpl;

    public CarrerController(CarrerServiceImpl carrerServiceImpl) {
        this.carrerServiceImpl = carrerServiceImpl;
    }

    @PostMapping
    public CarrerModel createCarrer(@RequestBody @Valid CarrerModel carrerModel){
        return carrerServiceImpl.createCarrer(carrerModel);
    }
    @GetMapping
    public ResponseCarrer findAll(CarrerModel carrerModel){
        List<CarrerModel> carrerModelList = carrerServiceImpl.findAll(carrerModel);
        return new ResponseCarrer(200, "success",carrerModelList);
    }
    @GetMapping("findby/{id}")
    public ResponseCarrer findById(@PathVariable("id") Long id) {
        if (carrerModel.class()) {
            CarrerModel carrerModel = carrerServiceImpl.findById(id);
            return new ResponseCarrer(200, "success", carrerModel);
        }
        return null;
    }
    @GetMapping("title/{jobtitle}")
    public List<CarrerModel> findAllByJobTitle(@PathVariable("jobtitle") String jobtitle,Pageable pageable){
        return carrerServiceImpl.findAllByJobTitle(jobtitle, pageable);
    }
    @PostMapping("/delete/{id}")
    public ResponseCarrer deleteById(@PathVariable ("id") Long id){
        boolean isDelete = carrerServiceImpl.deleteById(id);
        if(!isDelete)
            throw new CarrerNotFoundException(id, "Delete doesn't success");
        return new ResponseCarrer (200,"Sccuess Deleted Carrer By Id "+ id.toString(), id);
    }
    @PutMapping("/update/{id}")
    public ResponseCarrer updateCarrer(@PathVariable ("id") Long id,@RequestBody CarrerModel carrerModel){
        carrerServiceImpl.save(carrerModel, id);
        return new ResponseCarrer(200,"Success updated carrer",carrerModel);
    }
}
