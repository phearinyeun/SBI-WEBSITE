package com.sbilh.bank.SBIWEBSITE.repository;

import com.sbilh.bank.SBIWEBSITE.model.BranchesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchesRepository  extends JpaRepository<BranchesModel, Long> {
    List<BranchesModel> findByCategory(String category);
    List<BranchesModel> findByName (String name);
}
