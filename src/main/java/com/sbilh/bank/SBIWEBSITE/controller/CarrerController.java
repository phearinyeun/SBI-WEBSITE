package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.exception.NotFoundException;
import com.sbilh.bank.SBIWEBSITE.exception.respone.Response;
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

    @GetMapping
    public Response findAll(CarrerModel carrerModel){
        List<CarrerModel> carrerModelList = carrerServiceImpl.findAll(carrerModel);
        return new Response(200, "success",carrerModelList);
    }

    @GetMapping("/findby/{id}")
    public Response findById(@PathVariable("id") Long id) {
            Optional<CarrerModel> carrerModel = Optional.ofNullable(carrerServiceImpl.findById(id));
            if (carrerModel.isPresent()){
                log.info("Success find By ID {}", carrerModel);
                return new Response(200, "Success Find by ID ", carrerModel);
            }
            log.info("Could no find by ID {}", id);
            throw new NotFoundException(id, "Could not find by ID " +id.toString());
    }

    @GetMapping("title/{jobtitle}")
    public List<CarrerModel> findAllByJobTitle(@PathVariable("jobtitle") String jobtitle,Pageable pageable){
        carrerServiceImpl.findAllByJobTitle(jobtitle, pageable);
        if(jobtitle.equals(jobtitle)){
            return carrerServiceImpl.findAllByJobTitle(jobtitle, pageable);
        }
        return null;
    }

    @PostMapping("/de/{jobTitle}")
    public Optional<CarrerModel> deleteByJobTitle(@PathVariable("jobTitle") String jobTitle){
        carrerServiceImpl.deleteByJobtitle(jobTitle);
        return null;
    }

    @PostMapping
    public Response createCarrer(@RequestBody @Valid CarrerModel carrerModel){
        carrerServiceImpl.createCarrer(carrerModel);
        log.info("Success create carrer {}", carrerModel);
        return new Response(200, "Success Create Carrer", carrerModel);
    }

    @PostMapping("/delete/{id}")
    public Response deleteById(@PathVariable ("id") Long id){
        boolean isDelete = carrerServiceImpl.deleteById(id);
        if(!isDelete)
            throw new NotFoundException(id, "Doesn't found ID " + id.toString());
        return new Response(200,"Sccuess Deleted Carrer By Id "+ id.toString(), id);
    }

    @PostMapping("/update/{id}")
    public Response updateCarrer(@PathVariable ("id") Long id, @RequestBody CarrerModel carrerModel){
        carrerServiceImpl.save(carrerModel, id);
        return new Response(200,"Success updated carrer",carrerModel);
    }
}
