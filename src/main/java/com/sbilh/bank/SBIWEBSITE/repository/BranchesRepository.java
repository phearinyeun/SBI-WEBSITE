package com.sbilh.bank.SBIWEBSITE.repository;

import com.sbilh.bank.SBIWEBSITE.model.BranchesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchesRepository  extends JpaRepository<BranchesModel, Long> {
}
