package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.BranchesModel;

import java.util.List;
import java.util.Optional;

public interface BranchesService {
    BranchesModel create (BranchesModel branchesModel);
    Optional<BranchesModel> update (BranchesModel branchesModel, Long id);
    Long deleteById (Long id);
    BranchesModel findById(Long id);
    List<BranchesModel> findAll();
}
