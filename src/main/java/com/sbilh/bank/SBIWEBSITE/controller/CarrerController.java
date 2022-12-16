package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.exception.respone.Response;
import com.sbilh.bank.SBIWEBSITE.model.CarrerModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.CarrerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/carrer")
@Slf4j
public class CarrerController {
    private final CarrerServiceImpl carrerServiceImpl;

    public CarrerController(CarrerServiceImpl carrerServiceImpl) {
        this.carrerServiceImpl = carrerServiceImpl;
    }

    @GetMapping
    public Response findAll(CarrerModel carrerModel){
        return new Response(200, "success",carrerServiceImpl.findAll(carrerModel));
    }

    @GetMapping("/findby/{id}")
    public Response findById(@PathVariable("id") Long id) {
        return new Response(200, "Success Find by ID ", carrerServiceImpl.findById(id));
    }

    @GetMapping("title/{jobtitle}")
    public Response findAllByJobTitle(@PathVariable("jobtitle") String jobtitle,Pageable pageable){
        return new Response(200, "Success find by job tile", carrerServiceImpl.findAllByJobTitle(jobtitle, pageable));
    }

    @PostMapping
    public Response create (@RequestBody @Valid CarrerModel carrerModel){
        return new Response(200, "Success Create Carrer", carrerServiceImpl.createCarrer(carrerModel));
    }

    @PostMapping("/delete/{id}")
    public Response deleteById(@PathVariable ("id") Long id){
        return new Response(200,"Sccuess Deleted Carrer By Id ", carrerServiceImpl.deleteById(id));
    }

    @PostMapping("/update/{id}")
    public Response update (@PathVariable ("id") Long id, @RequestBody CarrerModel carrerModel){
        return new Response(200,"Success updated carrer",carrerServiceImpl.update(carrerModel, id));
    }
}
