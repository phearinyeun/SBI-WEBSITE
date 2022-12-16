package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.exception.respone.Response;
import com.sbilh.bank.SBIWEBSITE.model.FinancialHighlightModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.FinancialHighlightServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.OAEPParameterSpec;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/financial")
public class FinancialHighlightController {
    private final FinancialHighlightServiceImpl financialHighlightServiceImpl;

    public FinancialHighlightController(FinancialHighlightServiceImpl financialHighlightServiceImpl) {
        this.financialHighlightServiceImpl = financialHighlightServiceImpl;
    }

    @GetMapping
    public Response getAll (FinancialHighlightModel financialHighlightModel){
        List<FinancialHighlightModel> financialHighlightModelList = financialHighlightServiceImpl.findAll(financialHighlightModel);
        return new Response(200, "Sucees get all financail :", financialHighlightModelList);
    }

    @GetMapping("/find/{id}")
    public Response findbyId(@PathVariable ("id") Long id){
        Optional<FinancialHighlightModel> financialHighlightModelOptional = financialHighlightServiceImpl.findById(id);
        return new Response(200, "Success findy by ID: ", financialHighlightModelOptional);
    }

    @PostMapping
    public Response create (@RequestBody @Valid FinancialHighlightModel financialHighlightModel){
        financialHighlightServiceImpl.create(financialHighlightModel);
        return new Response(200, "Success create financial", financialHighlightModel);
    }

    @PostMapping("/update/{id}")
    public Response update (@PathVariable ("id") Long id, @RequestBody FinancialHighlightModel financialHighlightModel){
        financialHighlightServiceImpl.update(financialHighlightModel, id);
        return new Response(200, "Success updated :", financialHighlightModel);
    }

    @PostMapping("/delete/{id}")
    public Response deleteById(@PathVariable("id") Long id){
        financialHighlightServiceImpl.deleteById(id);
        return new Response(200, "Success deleted by ID: ",id);
    }
}
