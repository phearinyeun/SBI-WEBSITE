package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.exception.respone.Response;
import com.sbilh.bank.SBIWEBSITE.model.MobileBankingModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.MobileBankingServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "mobile")
public class MobileBankingController {
    private final MobileBankingServiceImpl mobileBankingServiceImpl;

    public MobileBankingController(MobileBankingServiceImpl mobileBankingServiceImpl) {
        this.mobileBankingServiceImpl = mobileBankingServiceImpl;
    }

    @PostMapping
    public MobileBankingModel create (@RequestBody MobileBankingModel mobileBankingModel){
        return mobileBankingServiceImpl.create(mobileBankingModel);
    }

    @PostMapping("/update/{id}")
    public Response update (@RequestBody MobileBankingModel mobileBankingModel, @PathVariable("id") Long id){
        return new Response(200, "Success updated ", mobileBankingServiceImpl.update(mobileBankingModel, id));
    }

    @PostMapping("/delete/{id}")
    public Response deleteById(@PathVariable("id") Long id){
        return new Response(200, "Success deleted by id ", mobileBankingServiceImpl.deleteById(id));
    }

    @GetMapping
    public Response findAll(MobileBankingModel mobileBankingModel){
        return new Response(200, "Success get all ", mobileBankingServiceImpl.findAll(mobileBankingModel));
    }

    @GetMapping("/find/{id}")
    public Response findById(@PathVariable("id") Long id){
        return new Response(200, "Success get id ", mobileBankingServiceImpl.findById(id));
    }

    @GetMapping("/name/{name}")
    public Response findByName(@PathVariable("name") String name){
        return new Response(200, "Success found by name ", mobileBankingServiceImpl.findByName(name));
    }
}
