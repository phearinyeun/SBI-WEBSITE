package com.sbilh.bank.SBIWEBSITE.service.impl;

import com.sbilh.bank.SBIWEBSITE.exception.NotFoundException;
import com.sbilh.bank.SBIWEBSITE.model.BranchesModel;
import com.sbilh.bank.SBIWEBSITE.repository.BranchesRepository;
import com.sbilh.bank.SBIWEBSITE.service.BranchesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BranchesServiceImpl implements BranchesService {
    private final BranchesRepository branchesRepository;

    public BranchesServiceImpl(BranchesRepository branchesRepository) {
        this.branchesRepository = branchesRepository;
    }

    @Override
    public BranchesModel create(BranchesModel branchesModel) {
        log.info("Success create branches {}", branchesModel);
        branchesRepository.save(branchesModel);
        return branchesModel;
    }

    @Override
    public Optional<BranchesModel> update(BranchesModel branchesModel, Long id) {
        Optional<BranchesModel> branchesModelOptional = branchesRepository.findById(id);
        if (branchesModelOptional.isPresent()){
            log.info("Success updated branches {}", id);
            branchesModel.setId(id);
            branchesRepository.save(branchesModel);
            return branchesModelOptional;
        }
        log.info("Could not found the Id {}", id);
        throw new NotFoundException(id, "Could not found the Id ", id.toString());
    }

    @Override
    public Long deleteById(Long id) {
        Optional<BranchesModel> branchesModelOptional = branchesRepository.deleteById();

    }

    @Override
    public BranchesModel findById(Long id) {
        Optional<BranchesModel> branchesModelOptional = branchesRepository.findById(id);
        if (branchesModelOptional.isPresent()){
            log.info("Sucess found the id {} ",id);
           branchesRepository.findById(id);
           return branchesModelOptional.get();
        }
        throw new NotFoundException(id,"Could not found the id ",id.toString());
    }

    @Override
    public List<BranchesModel> findAll() {
        return branchesRepository.findAll();
    }
}
