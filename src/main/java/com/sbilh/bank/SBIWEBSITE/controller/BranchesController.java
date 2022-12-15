package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.exception.respone.Response;
import com.sbilh.bank.SBIWEBSITE.model.BranchesModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.BranchesServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/branches")
public class BranchesController {
    private final BranchesServiceImpl branchesServiceImpl;

    public BranchesController(BranchesServiceImpl branchesServiceImpl) {
        this.branchesServiceImpl = branchesServiceImpl;
    }

    @PostMapping
    public Response create(@RequestBody @Valid BranchesModel branchesModel){
        return new Response(200, "Success create branches :", branchesServiceImpl.create(branchesModel));
    }

    @PostMapping("/update/{id}")
    public Response update(@RequestBody BranchesModel branchesModel, @PathVariable("id") Long id){
        return new Response(200, "Success update ",branchesServiceImpl.update(branchesModel, id));
    }

    @GetMapping
    public Response findAll(){
        return new Response(200, "Sucess find all branches : ", branchesServiceImpl.findAll());
    }

    @GetMapping("/find/{id}")
    public Response findById(@PathVariable("id") Long id){
        return new Response(200, "Success found the Id : ", branchesServiceImpl.findById(id));
    }

}
